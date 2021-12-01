package com.example.marvel.domain

import com.example.marvel.data.local.entity.CharactersEntity
import com.example.marvel.data.remote.MarvelService
import com.example.marvel.data.remote.State
import com.example.marvel.data.remote.respons.BaseResponse
import com.example.marvel.data.remote.respons.CharacterDto
import com.example.marvel.domain.model.Characters
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response


interface MarvelRepository{

    fun getCharacter(): Flow<State<List<Characters>?>>

}