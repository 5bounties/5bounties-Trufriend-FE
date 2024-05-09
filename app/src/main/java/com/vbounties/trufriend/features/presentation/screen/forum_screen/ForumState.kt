package com.vbounties.trufriend.features.presentation.screen.forum_screen

import com.vbounties.trufriend.features.data.remote.response.GetAllPostResponse

data class ForumState(
    val isLoading: Boolean = true,
    val message: String = "default",
    val data: GetAllPostResponse = GetAllPostResponse(
        status = 0,
        message = "default",
        data = listOf()
    )
)