package com.vbounties.trufriend.features.presentation.screen.login_screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vbounties.trufriend.features.domain.model.LoginModel
import com.vbounties.trufriend.features.domain.model.RegisterModel
import com.vbounties.trufriend.features.domain.repository.AuthRepository
import com.vbounties.trufriend.features.utils.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: AuthRepository
): ViewModel() {
    private val _loginstate = MutableStateFlow(LoginState())
    val loginstate = _loginstate.asStateFlow()

    fun register(request: RegisterModel) {
        viewModelScope.launch {
            _loginstate.update {
                it.copy(isLoading = true)
            }
            repository.PostRegister(request).collectLatest {
                when (it) {
                    is Result.Success -> {
                        _loginstate.update {
                            it.copy(
                                message = "Registrasi Berhasil",
                                isLoading = false,
                                data = it.data
                            )
                        }
                    }
                    is Result.Error -> {
                        _loginstate.update {
                            it.copy(
                                message = "Registrasi Gagal",
                                isLoading = false
                            )
                        }
                    }
                    is Result.Loading -> {
                        _loginstate.update {
                            it.copy(isLoading = it.isLoading)
                        }
                    }
                }
            }
        }
    }

    fun login(request: LoginModel){
        viewModelScope.launch {
            _loginstate.update {
                it.copy(isLoading = true)
            }
            repository.PostLogin(request).collectLatest {
                when (it) {
                    is Result.Success -> {
                        _loginstate.update {
                            it.copy(
                                message = "Login Berhasil",
                                isLoading = false,
                                data = it.data
                            )
                        }
                    }

                    is Result.Error -> {
                        _loginstate.update {
                            it.copy(
                                message = "Login Gagal",
                                isLoading = false
                            )
                        }
                    }

                    is Result.Loading -> {
                        _loginstate.update {
                            it.copy(isLoading = it.isLoading)
                        }
                    }
                }
            }
        }
    }
}