package com.vbounties.trufriend.features.domain.repository

import com.vbounties.trufriend.features.data.local.UserEntity
import com.vbounties.trufriend.features.data.remote.response.LoginResponse
import com.vbounties.trufriend.features.data.remote.response.RegisterResponse
import com.vbounties.trufriend.features.domain.model.LoginModel
import com.vbounties.trufriend.features.domain.model.RegisterModel
import com.vbounties.trufriend.features.utils.Result
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    suspend fun GetUserEntity(): Flow<Result<UserEntity>>
    suspend fun PostRegister(request: RegisterModel): Flow<Result<RegisterResponse>>
    suspend fun PostLogin(request: LoginModel):  Flow<Result<LoginResponse>>
}