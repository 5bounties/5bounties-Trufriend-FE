package com.vbounties.trufriend.features.domain.repository

import com.vbounties.trufriend.features.data.remote.response.UserResponse
import com.vbounties.trufriend.features.utils.Result
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun GetToken(): String
    suspend fun GetAllUser(): Flow<Result<UserResponse>>
    suspend fun GetUserById(id: String): Flow<Result<UserResponse>>
    suspend fun PostStoreUser()
    suspend fun PutUpdateUser()
    suspend fun DeleteUser()
}