package com.example.marvel.domain

import android.util.Log
import com.example.marvel.data.local.MarvelDataBase
import com.example.marvel.domain.model.*
import com.example.marvel.data.remote.*
import com.example.marvel.data.remote.respons.BaseResponse
import com.example.marvel.data.remote.respons.SeriesDto
import com.example.marvel.data.remote.respons.comics.ComicsDto
import com.example.marvel.domain.mapper.*
import kotlinx.coroutines.flow.*
import java.lang.Exception
import javax.inject.Inject


class MarvelRepositoryImpl @Inject constructor(
    private val apiService: MarvelService,
    private val marvelDataBase: MarvelDataBase,
    private val characterMapper: CharacterMapper,
    private val characterEntityMapper: CharacterEntityMapper,
    private val comicsEntityMapper: ComicsEntityMapper,
    private val comicsObjMapper: ComicsMapper,
    private val seriesEntityMapper: SeriesEntityMapper,
    private val seriesMapper: SeriesMapper,
    private val searchCharacterResultMapper: SearchCharacterResultMapper,
    private val searchCharacterResultEntityMapper: SearchCharacterResultEntityMapper,
    private val serierDtoToObjectMapper: SerierDtoToObjectMapper,
    private val comicsDtoToObjectMapper: ComicsDtoToObjectMapper
    ): MarvelRepository {

    override fun getCharacter(): Flow<List<Characters>> {
        return flow {
            marvelDataBase.MarvelDao().getCharacters().collect {
                emit(it.map{ characterMapper.map(it) })
            }
        }
    }

    override suspend fun getRefreshCharacters() {
        try {
            apiService.getCharacters().body()?.dataContainer?.items?.map {
                characterEntityMapper.map(it)
            }?.let { marvelDataBase.MarvelDao().insertCharacters(it.map { it }) }
        } catch(e: Exception){
            State.Error(e.message.toString())
        }
      }


    override fun getComics(): Flow<List<Comics>> {
        return flow {
            marvelDataBase.MarvelDao().getComics().collect {
                emit(it.map { comicsObjMapper.map(it) })
            }
        }
    }

    override fun getComicsResponse(): Flow<State<Item>> {
        return flow {
            emit(State.Loading)
            try {
                apiService.getComics().body()?.dataContainer?.items?.map {
                    emit(State.Success(comicsDtoToObjectMapper.map(it)))
                }
            }catch(e: Exception){
                State.Error(e.message.toString())
            }
        }
    }

    override suspend fun getRefreshComics() {
        try {
            apiService.getComics().body()?.dataContainer?.items?.map {
                comicsEntityMapper.map(it)
            }?.let { marvelDataBase.MarvelDao().insertComics(it.map { it }) }
        }catch(e: Exception){
            State.Error(e.message.toString())
        }

    }

    override fun getSeries(): Flow<List<Series>> {
        return flow {
            marvelDataBase.MarvelDao().getSeries().collect {
            emit(it.map { seriesMapper.map(it) })
            }
        }
    }

    override fun getSeriesResponse(): Flow<State<List<Item>>?> {
        return flow {
            emit(State.Loading)
            try {
                emit(State.Success(apiService.getSeries().body()?.dataContainer?.items?.map {
                    serierDtoToObjectMapper.map(it)
                }))
            }catch(e: Exception){
                State.Error(e.message.toString())
            }
        }
    }

    override suspend fun getRefreshSeries() {
        try {
            apiService.getSeries().body()?.dataContainer?.items?.map {
                seriesEntityMapper.map(it)
            }?.let { marvelDataBase.MarvelDao().insertSeries(it.map { it }) }
        }catch(e: Exception){
            State.Error(e.message.toString())
        }
    }


    override fun getCharacterRecentSearch(): Flow<List<SearchCharacterResult>> {
        return flow {
            marvelDataBase.MarvelDao().getSearchCharacterResult().collect {
                emit(it.map{ searchCharacterResultMapper.map(it) }) }
        }
    }

    override suspend fun getRefreshCharacterSearch(name: String) {
        try {
            apiService.getCharacterByName(name).body()?.dataContainer?.items?.map {
                searchCharacterResultEntityMapper.map(it)
            }?.let { marvelDataBase.MarvelDao().insertSearchCharacterResult(it.map { it }) }
        }catch(e: Exception){
            State.Error(e.message.toString())
        }
    }

    override fun getCharacterSearchByName(name: String): Flow<List<SearchCharacterResult>> {
        return flow {
            marvelDataBase.MarvelDao().getSearchCharacterResultByName(name).collect {
                emit(it.map{ searchCharacterResultMapper.map(it) }) }
        }
    }

    override fun getSeriesForSlider(): Flow<List<Series>> {
        return flow {
            marvelDataBase.MarvelDao().getSeriesForSlider(2020).collect {
                Log.i("sss", it.toString())
                emit(it.map{ seriesMapper.map(it) }) }
        }
    }


}