package com.vbounties.trufriend.features.data.repository
import android.content.Context
import android.util.Log
import com.vbounties.trufriend.features.data.local.UserDatabase
import com.vbounties.trufriend.features.data.local.UserEntity
import com.vbounties.trufriend.features.data.remote.TruefriendAPI
import com.vbounties.trufriend.features.data.remote.response.LoginResponse
import com.vbounties.trufriend.features.data.remote.response.RegisterResponse
import com.vbounties.trufriend.features.domain.model.LoginModel
import com.vbounties.trufriend.features.domain.model.RegisterModel
import com.vbounties.trufriend.features.domain.repository.AuthRepository
import com.vbounties.trufriend.features.utils.BitmapToFile
import com.vbounties.trufriend.features.utils.Result
import com.vbounties.trufriend.features.utils.bitmapToFile2
import com.vbounties.trufriend.features.utils.buildImageBodyPart
import com.vbounties.trufriend.features.utils.uriToBitmap
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val api: TruefriendAPI,
    private val userDatabase: UserDatabase
): AuthRepository {
    override suspend fun GetUserEntity(): Flow<Result<UserEntity>> {
        return flow {
            emit(Result.Loading(isLoading = true))
            try {
                val result = userDatabase.userDao().getUser()[userDatabase.userDao().getUser().size - 1]
                Log.d("UserEntity", result.toString())
                emit(Result.Success(data = result))
                emit(Result.Loading(isLoading = false))
                return@flow

            } catch (e: Exception){
                emit(Result.Loading(isLoading = false))
                emit(Result.Error(e.message.toString()))
                Log.d("UserEntity", e.message.toString())
                return@flow
            }
        }
    }

    override suspend fun PostRegister(context: Context, request: RegisterModel): Flow<Result<RegisterResponse>> {
        return flow {
            emit(Result.Loading(isLoading = true))

            val file = bitmapToFile2(context, request.avatar)
            val requestFile = file?.let { RequestBody.create("image/jpeg".toMediaTypeOrNull(), it) }
            val avatarPart = requestFile?.let { MultipartBody.Part.createFormData("avatar", file.name, it) } ?: return@flow

            Log.d("Register", avatarPart.toString())

            try {
                val response = api.postRegister(
                    name = request.name.toRequestBody(),
                    username = request.username.toRequestBody(),
                    email = request.email.toRequestBody(),
                    password = request.password.toRequestBody(),
                    avatar = avatarPart
                )

                Log.d("Register", response.toString())

                if(response.status == 201){
                    emit(Result.Success(response))
                    emit(Result.Loading(isLoading = false))
                    return@flow
                } else {
                    emit(Result.Loading(isLoading = false))
                    emit(Result.Error(response.message))
                    Log.d("Register", response.message)
                    Log.d("Register", response.toString())
                    return@flow
                }

            } catch (e: Exception){
                emit(Result.Loading(isLoading = false))
                emit(Result.Error(e.message.toString()))
                Log.d("Register", e.toString())
                return@flow
            }
        }
    }

    override suspend fun PostLogin(request: LoginModel): Flow<Result<LoginResponse>> {
        return flow{
            emit(Result.Loading(isLoading = true))
            try {
                val response = api.postLogin(loginRequest = request)

                Log.d("Login", response.toString())

                if(response.status == 200){
                    emit(Result.Success(response))
                    userDatabase.userDao().upserUser(user = UserEntity(
                        id = response.data.id,
                        name = response.data.name,
                        username = response.data.username,
                        email = response.data.email,
                        avatarUrl = response.data.avatarUrl,
                        token = response.data.token
                    ))
                    emit(Result.Loading(isLoading = false))
                    return@flow

                } else {
                    emit(Result.Loading(isLoading = false))
                    emit(Result.Error(response.message))
                    Log.d("Login", response.message)
                    return@flow
                }

            } catch (e: Exception){
                emit(Result.Loading(isLoading = false))
                emit(Result.Error(e.message.toString()))
                Log.d("Login", e.message.toString())
                return@flow
            }
        }
    }
}