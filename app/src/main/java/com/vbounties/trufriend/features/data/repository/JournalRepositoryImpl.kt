package com.vbounties.trufriend.features.data.repository

import android.util.Log
import com.vbounties.trufriend.features.data.remote.TruefriendAPI
import com.vbounties.trufriend.features.data.remote.response.GetAllJournalResponse
import com.vbounties.trufriend.features.data.remote.response.PostJournalResponse
import com.vbounties.trufriend.features.domain.model.JournalModel
import com.vbounties.trufriend.features.domain.repository.JournalRepository
import com.vbounties.trufriend.features.domain.repository.UserRepository
import com.vbounties.trufriend.features.utils.Constant
import com.vbounties.trufriend.features.utils.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class JournalRepositoryImpl @Inject constructor(
    private val api: TruefriendAPI,
    private val userRepository: UserRepository
): JournalRepository {
    override suspend fun getJournals(): Flow<Result<GetAllJournalResponse>> {
        return flow {
            emit(Result.Loading(isLoading = true))
            try {
                val response = api.getAllJournal(token = Constant.SUPERADMIN)
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

    override suspend fun postStoreJournal(request: JournalModel): Flow<Result<PostJournalResponse>> {
        return flow {
            emit(Result.Loading(isLoading = true))

            val token = "Bearer " + userRepository.GetToken()
            Log.d("Token", token)

            try {
                val response = api.postCreateJournal(token = token, entry = request)
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

    override suspend fun putEditJournal(id: String, request: JournalModel): Flow<Result<PostJournalResponse>> {
        return flow {
            emit(Result.Loading(isLoading = true))

            val token = "Bearer " + userRepository.GetToken()
            Log.d("Token", token)

            try {
                val response = api.putUpdateJournal(token = token, journal_id = id, entry = request)
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

            } catch (e: Exception) {
                Log.d("Error", e.message.toString())
                emit(Result.Error(e.message.toString()))
                emit(Result.Loading(isLoading = false))
                return@flow
            }
        }
    }

    override suspend fun deleteJournal(id: String): Flow<Result<GetAllJournalResponse>> {
        return flow {
            emit(Result.Loading(isLoading = true))

            val token = "Bearer " + userRepository.GetToken()
            Log.d("Token", token)

            try {
                val response = api.deleteJournal(token = token, journal_id = id)
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
}