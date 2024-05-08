package com.vbounties.trufriend.features.data.repository

import com.vbounties.trufriend.features.data.remote.TruefriendAPI
import com.vbounties.trufriend.features.domain.repository.PostRepository
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val api: TruefriendAPI
): PostRepository {
    override suspend fun GetAllPosts() {
        TODO("Not yet implemented")
    }

    override suspend fun PostStorePosts() {
        TODO("Not yet implemented")
    }

    override suspend fun PutEditPosts() {
        TODO("Not yet implemented")
    }

    override suspend fun DeletePosts() {
        TODO("Not yet implemented")
    }

    override suspend fun GetAllPostsLike() {
        TODO("Not yet implemented")
    }

    override suspend fun PostAddLike() {
        TODO("Not yet implemented")
    }

    override suspend fun DeleteRemoveLike() {
        TODO("Not yet implemented")
    }

    override suspend fun GetAllPostsComment() {
        TODO("Not yet implemented")
    }

    override suspend fun PostAddComment() {
        TODO("Not yet implemented")
    }

    override suspend fun DeleteRemoveComment() {
        TODO("Not yet implemented")
    }
}