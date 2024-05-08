package com.vbounties.trufriend.di

import com.vbounties.trufriend.features.data.repository.AuthRepositoryImpl
import com.vbounties.trufriend.features.data.repository.EmotionRepositoryImpl
import com.vbounties.trufriend.features.data.repository.JournalRepositoryImpl
import com.vbounties.trufriend.features.data.repository.PostRepositoryImpl
import com.vbounties.trufriend.features.data.repository.UserRepositoryImpl
import com.vbounties.trufriend.features.domain.repository.AuthRepository
import com.vbounties.trufriend.features.domain.repository.EmotionRepository
import com.vbounties.trufriend.features.domain.repository.JournalRepository
import com.vbounties.trufriend.features.domain.repository.PostRepository
import com.vbounties.trufriend.features.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindAuthRepository(
        authRepositoryImpl: AuthRepositoryImpl
    ): AuthRepository

    @Binds
    @Singleton
    abstract fun bindUserRepository(
        userRepositoryImpl: UserRepositoryImpl
    ): UserRepository

    @Binds
    @Singleton
    abstract fun bindEmotionRepository(
        emotionRepositoryImpl: EmotionRepositoryImpl
    ): EmotionRepository

    @Binds
    @Singleton
    abstract fun bindJournalRepository(
        journalRepositoryImpl: JournalRepositoryImpl
    ): JournalRepository

    @Binds
    @Singleton
    abstract fun bindPostRepository(
        postRepositoryImpl: PostRepositoryImpl
    ): PostRepository
}