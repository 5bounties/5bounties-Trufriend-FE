package com.vbounties.trufriend.features.data.remote.response

data class PostJournalResponse(
    val status: Int,
    val message: String,
    val data: JournalData
)

data class JournalData(
    val id: String,
    val content: String,
    val userId: String,
    val mood: String,
    val createdAt: String,
    val updatedAt: String
)