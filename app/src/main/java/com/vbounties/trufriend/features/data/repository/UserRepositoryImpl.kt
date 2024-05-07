package com.vbounties.trufriend.features.data.repository

import android.util.Log
import com.vbounties.trufriend.features.data.local.UserDatabase
import com.vbounties.trufriend.features.data.remote.TruefriendAPI
import com.vbounties.trufriend.features.data.remote.response.UserResponse
import com.vbounties.trufriend.features.domain.repository.UserRepository
import com.vbounties.trufriend.features.utils.Constant
import com.vbounties.trufriend.features.utils.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val api: TruefriendAPI,
    private val db: UserDatabase
): UserRepository {
    override suspend fun GetToken(): String {
        try {
            return db.userDao().getUser()[db.userDao().getUser().size - 1].token
        } catch (e: Exception){
            Log.d("get token", e.message.toString())
            return "error get token"
        }
    }
    override suspend fun GetAllUser(): Flow<Result<UserResponse>> {
        return flow {
            emit(Result.Loading(isLoading = true))
            try{
                val response = api.getAllUsers(Constant.SUPERADMIN)
                Log.d("Response", "response: $response")

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
            }
        }
    }

    override suspend fun GetUserById(id: String): Flow<Result<UserResponse>> {
        return flow {
            emit(Result.Loading(isLoading = true))
            try {
                val response = api.getUserById(Constant.SUPERADMIN, id)
                Log.d("Response", "response: $response")

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

    override suspend fun PostStoreUser() {
        TODO("Not yet implemented")
    }

    override suspend fun PutUpdateUser() {
        TODO("Not yet implemented")
    }

    override suspend fun DeleteUser() {
        TODO("Not yet implemented")
    }
}