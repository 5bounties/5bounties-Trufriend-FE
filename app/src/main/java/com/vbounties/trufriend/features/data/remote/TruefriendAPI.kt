package com.vbounties.trufriend.features.data.remote

import com.vbounties.trufriend.features.data.remote.response.LoginResponse
import com.vbounties.trufriend.features.data.remote.response.RegisterResponse
import com.vbounties.trufriend.features.domain.model.LoginModel
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface TruefriendAPI {
    @Multipart
    @POST("auth/register")
    suspend fun postRegister(
        @Part("name") name: RequestBody,
        @Part("username") username: RequestBody,
        @Part("email") email: RequestBody,
        @Part("password") password: RequestBody,
        @Part avatar: MultipartBody.Part
    ): RegisterResponse

//    @Headers(
//        "Content-Type: multipart/form-data",
//        "Accept: application/json"
//    )
//    @FormUrlEncoded
//    @POST("/auth/register")
//    suspend fun postRegister(
//        @Field("name") name: String,
//        @Field("username") username: String,
//        @Field("email") email: String,
//        @Field("password") password: String,
//        @Part avatar: MultipartBody.Part
//    ): RegisterResponse

//    @Headers(
//        "Accept: application/json"
//    )
//    @POST("/auth/register")
//    suspend fun postRegister(@Body requestBody: RequestBody): RegisterResponse

    @POST("auth/login")
    suspend fun postLogin(@Body loginRequest: LoginModel): LoginResponse
}