package com.vbounties.trufriend.features.data.remote.response

import java.util.*

data class GetAllPostResponse(
    val status: Int,
    val message: String,
    val data: List<Post>
)

data class Post(
    val id: String,
    val content: String,
    val imageUrl: String,
    val authorId: String,
    val createdAt: Date,
    val likes: List<String>,
    val comments: List<Comment>,
    val isVisible: Boolean
)

data class Comment(
    val id: String,
    val content: String,
    val userId: String,
    val postId: String,
    val createdAt: Date,
    val isVisible: Boolean
)
