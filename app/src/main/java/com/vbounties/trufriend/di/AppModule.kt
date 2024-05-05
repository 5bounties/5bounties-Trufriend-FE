package com.vbounties.trufriend.di

import android.content.Context
import androidx.room.Room
import com.vbounties.trufriend.features.data.local.UserDAO
import com.vbounties.trufriend.features.data.local.UserDatabase
import com.vbounties.trufriend.features.data.local.UserEntity
import com.vbounties.trufriend.features.data.remote.TruefriendAPI
import com.vbounties.trufriend.features.utils.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideTruefriendAPI(): TruefriendAPI {
        return Retrofit.Builder()
            .baseUrl(Constant.TRUFRIEND_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TruefriendAPI::class.java)
    }

    @Singleton
    @Provides
    fun provideUserDatabase(@ApplicationContext context: Context): UserDatabase =
        Room.databaseBuilder(context, UserDatabase::class.java, "user_db")
            .fallbackToDestructiveMigration()
            .build()

    @Singleton
    @Provides
    fun provideTokenDAO(UserDatabase: UserDatabase): UserDAO = UserDatabase.userDao()
}