package com.vbounties.trufriend.features.data.local

import androidx.room.ColumnInfo
import androidx.room.DatabaseView
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@DatabaseView
@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey
    val id: String,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "username")
    val username: String,

    @ColumnInfo(name = "email")
    val email: String,

    @ColumnInfo(name = "avatar_url")
    val avatarUrl: String,

    @ColumnInfo(name = "token")
    val token: String,

    @ColumnInfo(name = "timestamp")
    val timestamp: String = LocalDateTime.now().hour.toString()
)
