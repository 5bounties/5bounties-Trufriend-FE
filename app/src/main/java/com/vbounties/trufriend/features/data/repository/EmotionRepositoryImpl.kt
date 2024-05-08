package com.vbounties.trufriend.features.data.repository

import android.util.Log
import com.vbounties.trufriend.features.data.remote.TruefriendAPI
import com.vbounties.trufriend.features.data.remote.response.UserEmotionResponse
import com.vbounties.trufriend.features.domain.repository.AuthRepository
import com.vbounties.trufriend.features.domain.repository.EmotionRepository
import com.vbounties.trufriend.features.domain.repository.UserRepository
import com.vbounties.trufriend.features.utils.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class EmotionRepositoryImpl @Inject constructor(
    private val api: TruefriendAPI,
    private val userRepository: UserRepository
): EmotionRepository {
    override suspend fun getEmotions(): Flow<Result<UserEmotionResponse>> {
        return flow {
            emit(Result.Loading(isLoading = true))

            val token = "Bearer " + userRepository.GetToken()
            Log.d("Token", token)

            try {
                val response = api.getAllEmotion(token)
                Log.d("Response", response.toString())

                if(response.status == 200){
                    emit(Result.Success(response))
                    emit(Result.Loading(isLoading = false))
                    return@flow

                } else {
                    emit(Result.Error(response.message))
                    emit(Result.Loading(isLoading = false))
                    return@flow
                }
            } catch (e: Exception){
                Log.d("Error", e.message.toString())
                emit(Result.Error(e.message.toString()))
                emit(Result.Loading(isLoading = false))
                return@flow
            }
        }
    }

    override suspend fun getEmotionByID(id: String): Flow<Result<UserEmotionResponse>> {
        return flow {
            emit(Result.Loading(isLoading = true))
            val token = "Bearer " + userRepository.GetToken()
            Log.d("Token", token)

            try {
                val response = api.getEmotionById(id = id, token = token)
                Log.d("Response", response.toString())

                if(response.status == 200){
                    emit(Result.Success(response))
                    emit(Result.Loading(isLoading = false))
                    return@flow
                } else {
                    emit(Result.Error(response.message))
                    emit(Result.Loading(isLoading = false))
                    return@flow
                }

            } catch (e: Exception){
                emit(Result.Error(e.message.toString()))
                emit(Result.Loading(isLoading = false))
                Log.d("Error", e.message.toString())
                return@flow
            }
        }
    }

    override suspend fun postStoreEmotion() {
        TODO("Not yet implemented")
    }

    override suspend fun deleteEmotion(id: String) {
        TODO("Not yet implemented")
    }
}