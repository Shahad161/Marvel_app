package com.example.marvel.domain

import com.example.marvel.data.local.MarvelDataBase
import com.example.marvel.data.local.entity.CharactersEntity
import com.example.marvel.data.remote.MarvelService
import com.example.marvel.data.remote.respons.*
import com.example.marvel.data.remote.State
import com.example.marvel.domain.mapper.CharacterMapper
import com.example.marvel.domain.model.Characters
import kotlinx.coroutines.flow.*
import retrofit2.Response
import java.lang.Exception

class MarvelRepositoryImpl: MarvelRepository {

    private val apiService = MarvelService.apiService
    private val characterMapper = CharacterMapper()


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

}