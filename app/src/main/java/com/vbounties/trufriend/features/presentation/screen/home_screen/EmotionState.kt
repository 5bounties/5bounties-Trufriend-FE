package com.vbounties.trufriend.features.presentation.screen.home_screen

import com.vbounties.trufriend.features.data.remote.response.UserEmotionResponse

data class EmotionState(
    val isLoading: Boolean = true,
    val message: String = "default",
    val data: UserEmotionResponse = UserEmotionResponse(
        status = 0,
        message = "default",
        data = listOf()
    ),
)
