package com.vbounties.trufriend.features.data.repository

import android.util.Log
import com.vbounties.trufriend.features.data.remote.TruefriendAPI
import com.vbounties.trufriend.features.data.remote.response.GetAllPostResponse
import com.vbounties.trufriend.features.domain.repository.PostRepository
import com.vbounties.trufriend.features.domain.repository.UserRepository
import com.vbounties.trufriend.features.utils.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val api: TruefriendAPI,
    private val userRepository: UserRepository
): PostRepository {
    override suspend fun GetAllPosts(): Flow<Result<GetAllPostResponse>> {
        return flow {
            emit(Result.Loading(isLoading = true))

            val token = "Bearer " + userRepository.GetToken()
            Log.d("Token", token)

            try {
                val result = api.getAllPost(token)
                Log.d("GetAllPosts", result.toString())

                if(result.status == 200){
                    emit(Result.Success(result))
                    emit(Result.Loading(isLoading = false))
                    return@flow
                } else {
                    emit(Result.Error(result.message))
                    emit(Result.Loading(isLoading = false))
                    return@flow
                }

            } catch (e: Exception) {
                Log.d("GetAllPosts", e.message.toString())
                emit(Result.Error(e.message.toString()))
                emit(Result.Loading(isLoading = false))
                return@flow
            }
        }
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