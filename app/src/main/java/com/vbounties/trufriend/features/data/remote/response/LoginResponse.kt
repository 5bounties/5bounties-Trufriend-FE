package com.vbounties.trufriend.features.data.remote.response

data class LoginResponse(
    val status: Int,
    val message: String,
    val data: UserDataDetails2
)

data class UserDataDetails2(
    val id: String,
    val name: String,
    val email: String,
    val username: String,
    val avatarUrl: String
)
