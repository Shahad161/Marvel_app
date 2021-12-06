package com.example.marvel.domain

import com.example.marvel.data.remote.State
import com.example.marvel.domain.model.*
import kotlinx.coroutines.flow.Flow


interface MarvelRepository{

    fun getCharacter(): Flow<List<Characters>>
    suspend fun getRefreshCharacters()


    fun getComics(): Flow<List<Comics>>
    suspend fun getRefreshComics()


    fun getSeries(): Flow<List<Series>>
    suspend fun getRefreshSeries()


    fun getCharacterRecentSearch(): Flow<List<SearchCharacterResult>>
    suspend fun getRefreshCharacterSearch(name: String)
    fun getCharacterSearchByName(name: String): Flow<List<SearchCharacterResult>>

}