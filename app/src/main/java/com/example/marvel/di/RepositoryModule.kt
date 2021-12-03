package com.example.marvel.di

import com.example.marvel.data.local.MarvelDataBase
import com.example.marvel.data.remote.MarvelService
import com.example.marvel.domain.*
import com.example.marvel.domain.mapper.*
import com.example.marvel.ui.category.CategoriesFragment
import com.example.marvel.ui.category.series.SeriesFragment
import com.example.marvel.ui.category.stories.StoriesFragment
import dagger.*
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideRepository(characterMapper: CharacterMapper,
                          comicsEntityMapper: ComicsEntityMapper,
                          comicsObjMapper: ComicsMapper,
                          marvelDataBase: MarvelDataBase,
                          apiService: MarvelService): MarvelRepository{
        return MarvelRepositoryImpl(apiService, marvelDataBase, characterMapper, comicsEntityMapper, comicsObjMapper)
    }

    @Provides
    fun provideCharacterMapper() = CharacterMapper()

    @Provides
    fun provideComicsEntityMapper() = ComicsEntityMapper()

    @Provides
    fun provideComicsObjMapper() = ComicsMapper()

}