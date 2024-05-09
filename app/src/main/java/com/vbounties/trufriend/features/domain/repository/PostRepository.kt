package com.vbounties.trufriend.features.domain.repository

import com.vbounties.trufriend.features.data.remote.response.GetAllPostResponse
import com.vbounties.trufriend.features.utils.Result
import kotlinx.coroutines.flow.Flow

interface PostRepository {
    suspend fun GetAllPosts(): Flow<Result<GetAllPostResponse>>
    suspend fun PostStorePosts()
    suspend fun PutEditPosts()
    suspend fun DeletePosts()
    suspend fun GetAllPostsLike()
    suspend fun PostAddLike()
    suspend fun DeleteRemoveLike()
    suspend fun GetAllPostsComment()
    suspend fun PostAddComment()
    suspend fun DeleteRemoveComment()
}