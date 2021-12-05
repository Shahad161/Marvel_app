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

    fun getStories(): Flow<State<List<Stories>?>>
    suspend fun getRefreshStories()


    fun getCharacterByName(): Flow<State<List<SearchCharacterResult>>>
    suspend fun getRefreshCharacterByName(name: String)

    fun getLastCharacter(): Flow<State<List<SearchCharacterResult>>>

    fun getLastCharacterByName(name: String): Flow<State<List<SearchCharacterResult>>>
}