package com.vbounties.trufriend.features.data.remote.response

data class GetAllJournalResponse(
    val status: Int,
    val message: String,
    val data: List<JournalData2>
)

data class JournalData2(
    val id: String,
    val content: String,
    val userId: String,
    val mood: String,
    val createdAt: String,
    val updatedAt: String
)