package com.vbounties.trufriend.features.presentation.screen.test_screen

import com.vbounties.trufriend.features.data.remote.response.Users

data class UserState(
    val isLoading: Boolean = true,
    val message: String = "default",
    val data: List<Users> = emptyList()
)