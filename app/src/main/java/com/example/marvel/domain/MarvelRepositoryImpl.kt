package com.example.marvel.domain

import com.example.marvel.data.local.MarvelDataBase
import com.example.marvel.domain.model.*
import com.example.marvel.data.remote.*
import com.example.marvel.domain.mapper.*
import kotlinx.coroutines.flow.*
import java.lang.Exception


class MarvelRepositoryImpl(
    private val apiService: MarvelService,
    private val marvelDataBase: MarvelDataBase,
    private val characterMapper: CharacterMapper,
    private val characterEntityMapper: CharacterEntityMapper,
    private val comicsEntityMapper: ComicsEntityMapper,
    private val comicsObjMapper: ComicsMapper,
    private val seriesEntityMapper: SeriesEntityMapper,
    private val seriesMapper: SeriesMapper,
    private val searchCharacterResultMapper: SearchCharacterResultMapper,
    private val searchCharacterResultEntityMapper: SearchCharacterResultEntityMapper

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

    override suspend fun getRefreshSeries() {
        try {
            apiService.getSeries().body()?.dataContainer?.items?.map {
                seriesEntityMapper.map(it)
            }?.let { marvelDataBase.MarvelDao().insertSeries(it.map { it }) }
        }catch(e: Exception){
            State.Error(e.message.toString())
        }
    }


    override fun getCharacterByName(): Flow<State<List<SearchCharacterResult>>> {
        return flow {
            emit(State.Loading)
            try {
                marvelDataBase.MarvelDao().getSearchCharacterResult().collect {
                    emit(State.Success(it.map{ searchCharacterResultMapper.map(it) }))
                }
            }catch(e: Exception){
                emit(State.Error(e.message.toString()))
            }
        }
    }

    override suspend fun getRefreshCharacterByName(name: String) {
        try {
            apiService.getCharacterByName(name).body()?.dataContainer?.items?.map {
                searchCharacterResultEntityMapper.map(it)
            }?.let { marvelDataBase.MarvelDao().insertSearchCharacterResult(it.map { it }) }
        }catch(e: Exception){
            State.Error(e.message.toString())
        }
    }


    override fun getLastCharacter(): Flow<State<List<SearchCharacterResult>>> {
        return flow {
            emit(State.Loading)
            try {
                marvelDataBase.MarvelDao().getLastSearchCharacterResult().collect {
                    emit(State.Success(it.map{ searchCharacterResultMapper.map(it) }))
                }
            }catch(e: Exception){
                emit(State.Error(e.message.toString()))
            }
        }
    }

    override fun getLastCharacterByName(name: String): Flow<State<List<SearchCharacterResult>>> {
        return flow {
            emit(State.Loading)
            try {
                marvelDataBase.MarvelDao().getSearchCharacterResultByName(name).collect {
                    emit(State.Success(it.map{ searchCharacterResultMapper.map(it) }))
                }
            }catch(e: Exception){
                emit(State.Error(e.message.toString()))
            }

        }
    }
}