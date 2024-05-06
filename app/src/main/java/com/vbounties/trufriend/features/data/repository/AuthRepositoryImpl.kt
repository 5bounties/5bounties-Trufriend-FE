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
                val result = userDatabase.userDao().getUser()
                emit(Result.Loading(isLoading = false))

                Log.d("UserEntity", result.toString())

                emit(Result.Success(result[0]))

            } catch (e: Exception){
                emit(Result.Loading(isLoading = false))
                emit(Result.Error(e.message.toString()))
                Log.d("UserEntity", e.message.toString())
            }
        }
    }

    override suspend fun PostRegister(context: Context, request: RegisterModel): Flow<Result<RegisterResponse>> {
        return flow {
            emit(Result.Loading(isLoading = true))

            // val bitmap = uriToBitmap(context, request.avatar)
            // MultipartBody.Part.createFormData("image", request.avatar.name, request.avatar.asRequestBody())

            val multipart = buildImageBodyPart(context, request.name, request.avatar)
            Log.d("Register", multipart.toString())

            try {
                val response = api.postRegister(
                    name = request.name.toRequestBody(),
                    username = request.username.toRequestBody(),
                    email = request.email.toRequestBody(),
                    password = request.password.toRequestBody(),
                    avatar = multipart
                )

                Log.d("Register", response.toString())

                if(response.status == 201){
                    emit(Result.Loading(isLoading = false))
                    emit(Result.Success(response))

                    userDatabase.userDao().upserUser(user = UserEntity(
                        id = response.data.id,
                        name = response.data.name,
                        username = response.data.username,
                        email = response.data.email,
                        avatarUrl = response.data.avatarUrl
                    ))

                } else {
                    emit(Result.Loading(isLoading = false))
                    emit(Result.Error(response.message))
                    Log.d("Register", response.message)
                    Log.d("Register", response.toString())
                }

            } catch (e: Exception){
                emit(Result.Loading(isLoading = false))
                emit(Result.Error(e.message.toString()))
                Log.d("Register", e.toString())
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
                    emit(Result.Loading(isLoading = false))
                    emit(Result.Success(response))

                    userDatabase.userDao().upserUser(user = UserEntity(
                        id = response.data.id,
                        name = response.data.name,
                        username = response.data.username,
                        email = response.data.email,
                        avatarUrl = response.data.avatarUrl
                    ))

                } else {
                    emit(Result.Loading(isLoading = false))
                    emit(Result.Error(response.message))
                    Log.d("Login", response.message)
                }

            } catch (e: Exception){
                emit(Result.Loading(isLoading = false))
                emit(Result.Error(e.message.toString()))
                Log.d("Login", e.message.toString())
            }
        }
    }
}