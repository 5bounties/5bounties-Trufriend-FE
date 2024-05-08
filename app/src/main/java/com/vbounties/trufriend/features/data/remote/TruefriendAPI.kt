package com.vbounties.trufriend.features.data.remote

import com.vbounties.trufriend.features.data.remote.response.GetAllJournalResponse
import com.vbounties.trufriend.features.data.remote.response.GetAllPostResponse
import com.vbounties.trufriend.features.data.remote.response.UserResponse
import com.vbounties.trufriend.features.data.remote.response.LoginResponse
import com.vbounties.trufriend.features.data.remote.response.PostJournalResponse
import com.vbounties.trufriend.features.data.remote.response.RegisterResponse
import com.vbounties.trufriend.features.data.remote.response.UserEmotionResponse
import com.vbounties.trufriend.features.domain.model.JournalModel
import com.vbounties.trufriend.features.domain.model.LoginModel
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.Path

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

    @POST("auth/login")
    suspend fun postLogin(@Body loginRequest: LoginModel): LoginResponse

    @GET("users")
    suspend fun getAllUsers(
        @Header("superadmin") token: String
    ): UserResponse

    @GET("users/{id}")
    suspend fun getUserById(
        @Header("superadmin") token: String,
        @Path("id") id: String
    ): UserResponse

    @GET("emotion")
    suspend fun getAllEmotion(
        @Header("Authorization") token: String
    ): UserEmotionResponse

    @GET("emotion/{id}")
    suspend fun getEmotionById(
        @Header("Authorization") token: String,
        @Path("id") id: String
    ): UserEmotionResponse

    @GET("journal")
    suspend fun getAllJournal(
        @Header("superadmin") token: String
    ): GetAllJournalResponse

    @POST("journal")
    suspend fun postCreateJournal(
        @Header("Authorization") token: String,
        @Body entry: JournalModel
    ): PostJournalResponse

    @PUT("journal/{journal_id}")
    suspend fun putUpdateJournal(
        @Header("Authorization") token: String,
        @Path("journal_id") journal_id: String,
        @Body entry: JournalModel
    ): PostJournalResponse

    @DELETE("journal/{journal_id}")
    suspend fun deleteJournal(
        @Header("Authorization") token: String,
        @Path("journal_id") journal_id: String
    ): GetAllJournalResponse

    @GET("post")
    suspend fun getAllPost(
        @Header("Authorization") token: String
    ): GetAllPostResponse

    @Multipart
    @POST("post")
    suspend fun PostCreatePost(
        @Header("Authorization") token: String,
        @Part("content") content: RequestBody,
        @Part image: MultipartBody.Part
    )

    @PUT("post/{post_id}")
    suspend fun putUpdatePost(
        @Header("Authorization") token: String,
        @Path("post_id") post_id: String,
        @Body content: RequestBody,
        @Part image: MultipartBody.Part
    )

    @DELETE("post/{post_id}")
    suspend fun deletePost(
        @Header("Authorization") token: String,
        @Path("post_id") post_id: String
    )

    @GET("post/{post_id}/likes")
    suspend fun getLikePost(
        @Header("Authorization") token: String,
        @Path("post_id") post_id: String
    )

    @POST("post/{post_id}/likes")
    suspend fun PostAddLike(
        @Header("Authorization") token: String,
        @Path("post_id") post_id: String
    )

    @DELETE("post/{post_id}/likes")
    suspend fun deleteLikePost(
        @Header("Authorization") token: String,
        @Path("post_id") post_id: String
    )

    @GET("post/{post_id}/comments")
    suspend fun getCommentPost(
        @Header("Authorization") token: String,
        @Path("post_id") post_id: String
    )

    @POST("post/{post_id}/comments")
    suspend fun PostAddComment(
        @Header("Authorization") token: String,
        @Path("post_id") post_id: String,
        @Body content: RequestBody
    )

    @DELETE("post/{post_id}/comments/{comment_id}")
    suspend fun deleteComment(
        @Header("Authorization") token: String,
        @Path("post_id") post_id: String,
        @Path("comment_id") comment_id: String
    )
}