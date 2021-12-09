package com.example.marvel.domain

import com.example.marvel.data.remote.State
import com.example.marvel.data.remote.respons.BaseResponse
import com.example.marvel.data.remote.respons.SeriesDto
import com.example.marvel.data.remote.respons.comics.ComicsDto
import com.example.marvel.domain.model.*
import kotlinx.coroutines.flow.Flow


interface MarvelRepository{

    fun getCharacter(): Flow<List<Characters>>
    suspend fun getRefreshCharacters()


    fun getComics(): Flow<List<Comics>>
    fun getComicsResponse(): Flow<State<Item>>
    suspend fun getRefreshComics()



    fun getSeries(): Flow<List<Series>>
    fun getSeriesResponse(): Flow<State<List<Item>>?>
    suspend fun getRefreshSeries()


    fun getCharacterRecentSearch(): Flow<List<SearchCharacterResult>>
    suspend fun getRefreshCharacterSearch(name: String)
    fun getCharacterSearchByName(name: String): Flow<List<SearchCharacterResult>>

    fun getSeriesForSlider(): Flow<List<Series>>

}