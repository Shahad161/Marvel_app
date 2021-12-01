package com.example.marvel.domain

import com.example.marvel.domain.mapper.CharacterMapper
import com.example.marvel.domain.model.Characters
import com.example.marvel.data.remote.*
import kotlinx.coroutines.flow.*
import java.lang.Exception

class MarvelRepositoryImpl(
    private val apiService: MarvelService,
    private val characterMapper: CharacterMapper
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

}