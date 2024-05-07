package com.vbounties.trufriend.features.domain.repository

interface PostRepository {
    suspend fun getPosts()
    suspend fun postStorePost()
}