package com.vbounties.trufriend.features.domain.model

import android.graphics.Bitmap
import android.net.Uri
import java.io.File

data class RegisterModel(
    val name: String,
    val username: String,
    val email: String,
    val password: String,
    val avatar: Bitmap
)
