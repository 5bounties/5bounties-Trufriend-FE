package com.vbounties.trufriend.features.domain.repository

import com.vbounties.trufriend.features.data.remote.response.GetAllJournalResponse
import com.vbounties.trufriend.features.data.remote.response.PostJournalResponse
import com.vbounties.trufriend.features.domain.model.JournalModel
import com.vbounties.trufriend.features.utils.Result
import java.util.concurrent.Flow

interface JournalRepository {
    suspend fun getJournals(): kotlinx.coroutines.flow.Flow<Result<GetAllJournalResponse>>
    suspend fun postStoreJournal(request: JournalModel): kotlinx.coroutines.flow.Flow<Result<PostJournalResponse>>
    suspend fun putEditJournal(id: String, request: JournalModel): kotlinx.coroutines.flow.Flow<Result<PostJournalResponse>>
    suspend fun deleteJournal(id: String): kotlinx.coroutines.flow.Flow<Result<GetAllJournalResponse>>
}