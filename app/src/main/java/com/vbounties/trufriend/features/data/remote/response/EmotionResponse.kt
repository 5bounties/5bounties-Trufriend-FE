package com.vbounties.trufriend.features.data.remote.response

import com.google.gson.annotations.SerializedName

data class UserEmotionResponse(
    @SerializedName("status")
    val status: Int,
    @SerializedName("message")
    val message: String,
    @SerializedName("data")
    val data: List<UserEmotion>
)

data class UserEmotion(
    @SerializedName("id")
    val id: String,
    @SerializedName("mood")
    val mood: String,
    @SerializedName("userId")
    val userId: String,
    @SerializedName("createdAt")
    val createdAt: String
)