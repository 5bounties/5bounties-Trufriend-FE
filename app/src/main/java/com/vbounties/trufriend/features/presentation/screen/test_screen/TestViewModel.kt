package com.vbounties.trufriend.features.presentation.screen.test_screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
class TestViewModel @Inject constructor(
    private val userRepository: UserRepository
): ViewModel() {
    private val _userstate = MutableStateFlow(UserState())
    val userstate = _userstate.asStateFlow()

    init {
        getAllUsers()
    }
    fun getAllUsers(){
        viewModelScope.launch {
           userRepository.GetAllUser().collectLatest {
               when (it) {
                   is Result.Success -> {
                       _userstate.update {
                           it.copy(
                               message = "Fetch Berhasil",
                               isLoading = false,
                               data = it.data
                           )
                       }
                   }
                   is Result.Error -> {
                       _userstate.update {
                           it.copy(
                               message = "Fetch Gagal",
                               isLoading = false
                           )
                       }
                   }
                   is Result.Loading -> {
                       _userstate.update {
                           it.copy(isLoading = it.isLoading)
                       }
                   }
               }
           }
            Log.d("TAG", "getAllUsers: $userstate")
        }
    }
}