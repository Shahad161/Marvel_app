package com.example.marvel.domain

import androidx.lifecycle.asLiveData
import com.example.marvel.data.local.MarvelDataBase
import com.example.marvel.data.local.entity.ComicsEntity
import com.example.marvel.domain.mapper.CharacterMapper
import com.example.marvel.domain.model.Characters
import com.example.marvel.data.remote.*
import com.example.marvel.domain.mapper.ComicsMapper
import com.example.marvel.domain.mapper.ComicsObjectMapper
import com.example.marvel.domain.model.Comics
import kotlinx.coroutines.flow.*
import java.lang.Exception

class MarvelRepositoryImpl(
    private val apiService: MarvelService,
    private val marvelDataBase: MarvelDataBase,
    private val characterMapper: CharacterMapper,
    private val comicsMapper: ComicsMapper,
    private val comicsObjMapper: ComicsObjectMapper
): MarvelRepository {

    override fun getCharacter(): Flow<State<List<Characters>?>> {
        return flow {
            emit(State.Loading)
            try {
                val charactersa = apiService.getCharacters().body()?.dataContainer?.items?.map {
                    characterMapper.map(it)
                }
                emit(State.Success(charactersa))
            }catch(e: Exception){
                emit(State.Error(e.message.toString()))
            }
        }
    }



    override fun getComics(): Flow<State<List<Comics>>> {
        return flow {
            emit(State.Loading)
            try {
                val charactersa= marvelDataBase.MarvelDao().getComics().collect {
                    emit(State.Success(it.map { comicsObjMapper.map(it) }))
                }
            }catch(e: Exception){
                emit(State.Error(e.message.toString()))
            }
        }
    }

    override suspend fun getRefreshComics() {
        val comics = apiService.getComics().body()?.dataContainer?.items?.map {
            comicsMapper.map(it)
        }
        comics?.let { marvelDataBase.MarvelDao().insertComics(it.map { it }) }
    }

}