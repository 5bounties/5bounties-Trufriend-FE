package com.vbounties.trufriend.features.data.remote.response

data class RegisterResponse(
    val status: Int,
    val message: String,
    val data: UserDataDetails
)

data class UserDataDetails(
    val id: String,
    val name: String,
    val email: String,
    val username: String,
    val avatarUrl: String
)
