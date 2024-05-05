package com.vbounties.trufriend.features.data.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface UserDAO {
    @Upsert
    suspend fun upserUser(user: UserEntity)

    @Query("SELECT * FROM user")
    suspend fun getUser(): List<UserEntity>
}