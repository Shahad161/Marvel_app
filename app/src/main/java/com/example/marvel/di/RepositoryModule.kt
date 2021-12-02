package com.example.marvel.di

import com.example.marvel.data.local.MarvelDataBase
import com.example.marvel.data.remote.MarvelService
import com.example.marvel.domain.*
import com.example.marvel.domain.mapper.*
import dagger.*
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideRepository(characterMapper: CharacterMapper,
                          comicsMapper: ComicsMapper,
                          comicsObjMapper: ComicsObjectMapper,
                          marvelDataBase: MarvelDataBase,
                          apiService: MarvelService): MarvelRepository{
        return MarvelRepositoryImpl(apiService, marvelDataBase, characterMapper, comicsMapper, comicsObjMapper)
    }

    @Provides
    fun provideCharacterMapper() = CharacterMapper()

    @Provides
    fun provideComicsEntityMapper() = ComicsMapper()

    @Provides
    fun provideComicsObjMapper() = ComicsObjectMapper()

}