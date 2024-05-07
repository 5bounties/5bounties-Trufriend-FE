package com.vbounties.trufriend.features.domain.repository

interface EmotionRepository {
    suspend fun getEmotions()
    suspend fun getEmotionByID(id: String)
    suspend fun postStoreEmotion()
    suspend fun deleteEmotion(id: String)

}