package com.vbounties.trufriend.features.presentation.screen.login_screen

import com.vbounties.trufriend.features.data.remote.response.UserDataDetails

data class LoginState(
    val isLoading: Boolean = true,
    val message: String = "default",
    val data: UserDataDetails? = null
)