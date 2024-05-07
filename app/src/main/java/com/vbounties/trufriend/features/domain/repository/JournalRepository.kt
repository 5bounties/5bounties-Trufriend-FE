package com.vbounties.trufriend.features.domain.repository

interface JournalRepository {
    suspend fun getJournals()
    suspend fun getJournalById(id: String)
    suspend fun postStoreJournal()
    suspend fun putEditJournal()
    suspend fun deleteJournal()

}