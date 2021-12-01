package com.example.marvel.di

import com.example.marvel.data.remote.MarvelService
import com.example.marvel.domain.MarvelRepository
import com.example.marvel.domain.MarvelRepositoryImpl
import com.example.marvel.domain.mapper.CharacterMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideRepository(characterMapper: CharacterMapper, apiService: MarvelService): MarvelRepository{
        return MarvelRepositoryImpl(apiService, characterMapper)
    }

    @Provides
    fun provideCharacterMapper() = CharacterMapper()


}