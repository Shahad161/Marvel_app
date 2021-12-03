package com.example.marvel.di

import com.example.marvel.data.local.MarvelDataBase
import com.example.marvel.data.remote.MarvelService
import com.example.marvel.domain.*
import com.example.marvel.domain.mapper.*
import dagger.hilt.components.SingletonComponent
import dagger.hilt.InstallIn
import dagger.*


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideRepository(characterMapper: CharacterMapper,
                          comicsEntityMapper: ComicsEntityMapper,
                          comicsObjMapper: ComicsMapper,
                          seriesEntityMapper: SeriesEntityMapper,
                          seriesMapper: SeriesMapper,
                          marvelDataBase: MarvelDataBase,
                          apiService: MarvelService): MarvelRepository{
        return MarvelRepositoryImpl(apiService, marvelDataBase, characterMapper, comicsEntityMapper, comicsObjMapper, seriesEntityMapper, seriesMapper)
    }

    @Provides
    fun provideCharacterMapper() = CharacterMapper()

    @Provides
    fun provideComicsEntityMapper() = ComicsEntityMapper()

    @Provides
    fun provideComicsObjMapper() = ComicsMapper()

    @Provides
    fun provideSeriesEntityMapper() = SeriesEntityMapper()

    @Provides
    fun provideSeriesMapper() = SeriesMapper()

}