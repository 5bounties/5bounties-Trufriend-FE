package com.vbounties.trufriend.features.domain.model

import java.io.File

data class RegisterModel(
    val name: String,
    val username: String,
    val email: String,
    val password: String,
    val avatar: File
)
