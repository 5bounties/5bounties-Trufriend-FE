package com.vbounties.trufriend.features.presentation.screen.profile_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vbounties.trufriend.features.domain.repository.AuthRepository
import com.vbounties.trufriend.features.domain.repository.UserRepository
import com.vbounties.trufriend.features.utils.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val userRepository: UserRepository
): ViewModel() {
    private val _userstate = MutableStateFlow(UserState())
    val userstate = _userstate.asStateFlow()

    init {
        getUser()
    }

    fun getUser() {
        viewModelScope.launch {
            authRepository.GetUserEntity().collectLatest { result ->
                when(result) {
                    is Result.Success -> {
                        result.data?.let { userEntity ->
                            _userstate.update { currentState ->
                                currentState.copy(
                                    message = "Fetch Berhasil",
                                    isLoading = false,
                                    data = userEntity
                                )
                            }
                        }
                    }
                    is Result.Error -> {
                        _userstate.update { currentState ->
                            currentState.copy(
                                message = result.message ?: "Fetch Gagal", // Use result.message or default message
                                isLoading = false
                            )
                        }
                    }
                    is Result.Loading -> {
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