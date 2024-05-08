package com.vbounties.trufriend.features.domain.repository

interface PostRepository {
    suspend fun GetAllPosts()
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