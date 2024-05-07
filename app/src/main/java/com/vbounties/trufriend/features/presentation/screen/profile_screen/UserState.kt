package com.vbounties.trufriend.features.presentation.screen.profile_screen

import com.vbounties.trufriend.features.data.local.UserEntity


data class UserState(
    val isLoading: Boolean = true,
    val message: String = "default",
    val data: UserEntity = UserEntity(
        id = "dummy",
        name = "dummy",
        username = "dummy",
        email = "dummy@gmail.com",
        token = "dummy",
        avatarUrl = "dummy"
    )
)