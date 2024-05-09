package com.vbounties.trufriend.features.presentation.screen.forum_screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vbounties.trufriend.features.data.local.UserEntity
import com.vbounties.trufriend.features.data.remote.response.GetAllPostResponse
import com.vbounties.trufriend.features.domain.repository.AuthRepository
import com.vbounties.trufriend.features.domain.repository.PostRepository
import com.vbounties.trufriend.features.domain.repository.UserRepository
import com.vbounties.trufriend.features.presentation.screen.profile_screen.UserState
import com.vbounties.trufriend.features.utils.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ForumViewModel @Inject constructor(
    private val forumRepository: PostRepository,
    private val authRepository: AuthRepository
): ViewModel() {
    private val _forumstate = MutableStateFlow(ForumState())
    val forumstate = _forumstate.asStateFlow()

    fun getAllPost(
        onFinished: (ForumState) -> Unit
    ){
        viewModelScope.launch {
            forumRepository.GetAllPosts().collect{ result ->
                when(result){
                    is Result.Success -> {
                        _forumstate.update { currentState ->
                            currentState.copy(
                                message = "Fetch Berhasil",
                                isLoading = false,
                                data = result.data ?: GetAllPostResponse(0, "default", emptyList())
                            )
                        }
                        onFinished(forumstate.value)
                    }

                    is Result.Error -> {
                        _forumstate.update { currentState ->
                            currentState.copy(
                                message = result.message ?: "Fetch Gagal",
                                isLoading = false
                            )
                        }
                    }

                    is Result.Loading -> {
                        _forumstate.update { currentState ->
                            currentState.copy(
                                isLoading = result.isLoading
                            )
                        }
                    }
                }
            }
        }
    }

    private val _userstate = MutableStateFlow(UserState())
    val userstate = _userstate.asStateFlow()

    fun getUser(onFinished: (UserState) -> Unit) {
        viewModelScope.launch {
            authRepository.GetUserEntity().collect { result ->
                when(result) {
                    is Result.Success -> {
                        Log.d("ProfileViewModel", "getUser: ${result.data}")
                        _userstate.update { currentState ->
                            currentState.copy(
                                message = "Fetch Berhasil",
                                isLoading = false,
                                data = result.data ?: UserEntity("", "", "", "", "", "")
                            )
                        }
                        Log.d("ProfileViewModel", "userState: ${userstate.value}")
                        onFinished(userstate.value)
                    }
                    is Result.Error -> {
                        Log.d("ProfileViewModel", "getUser: ${result.data}")
                        _userstate.update { currentState ->
                            currentState.copy(
                                message = result.message ?: "Fetch Gagal",
                                isLoading = false
                            )
                        }
                    }
                    is Result.Loading -> {
                        Log.d("ProfileViewModel", "getUser: ${result.data}")
                        _userstate.update { currentState ->
                            currentState.copy(
                                isLoading = result.isLoading
                            )
                        }
                    }
                }
            }
        }
    }
}