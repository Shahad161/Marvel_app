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
                          characterEntityMapper: CharacterEntityMapper,
                          searchCharacterResultMapper: SearchCharacterResultMapper,
                          searchCharacterResultEntityMapper: SearchCharacterResultEntityMapper,
                          comicsEntityMapper: ComicsEntityMapper,
                          comicsObjMapper: ComicsMapper,
                          seriesEntityMapper: SeriesEntityMapper,
                          seriesMapper: SeriesMapper,
                          serierDtoToObjectMapper: SerierDtoToObjectMapper,
                          comicsDtoToObjectMapper: ComicsDtoToObjectMapper,
                          marvelDataBase: MarvelDataBase,
                          apiService: MarvelService): MarvelRepository{
        return MarvelRepositoryImpl(
            apiService,
            marvelDataBase,
            characterMapper,
            characterEntityMapper,
            comicsEntityMapper,
            comicsObjMapper,
            seriesEntityMapper,
            seriesMapper,
            searchCharacterResultMapper,
            searchCharacterResultEntityMapper,
            serierDtoToObjectMapper,
            comicsDtoToObjectMapper
        )
    }


    @Provides
    fun provideCharacterMapper() = CharacterMapper()

    @Provides
    fun provideCharacterEntityMapper() = CharacterEntityMapper()


    @Provides
    fun provideSearchCharacterResultMapper() = SearchCharacterResultMapper()

    @Provides
    fun provideSearchCharacterResultEntityMapper() = SearchCharacterResultEntityMapper()


    @Provides
    fun provideComicsEntityMapper() = ComicsEntityMapper()

    @Provides
    fun provideComicsObjMapper() = ComicsMapper()


    @Provides
    fun provideSeriesEntityMapper() = SeriesEntityMapper()

    @Provides
    fun provideSeriesMapper() = SeriesMapper()

    @Provides
    fun provideSeriesToObjectMapper() = SerierDtoToObjectMapper()

    @Provides
    fun provideComicsToObjectMapper() = ComicsDtoToObjectMapper()

}