package com.vbounties.trufriend.features.domain.repository

import com.vbounties.trufriend.features.data.remote.response.UserEmotionResponse
import com.vbounties.trufriend.features.utils.Result
import kotlinx.coroutines.flow.Flow

interface EmotionRepository {
    suspend fun getEmotions(): Flow<Result<UserEmotionResponse>>
    suspend fun getEmotionByID(id: String): Flow<Result<UserEmotionResponse>>
    suspend fun postStoreEmotion()
    suspend fun deleteEmotion(id: String)
}