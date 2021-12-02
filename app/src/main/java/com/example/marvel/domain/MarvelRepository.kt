package com.example.marvel.domain

import com.example.marvel.data.local.entity.ComicsEntity
import com.example.marvel.data.remote.State
import com.example.marvel.domain.model.Characters
import com.example.marvel.domain.model.Comics
import kotlinx.coroutines.flow.Flow


interface MarvelRepository{

    fun getCharacter(): Flow<State<List<Characters>?>>

    fun getComics(): Flow<State<List<Comics>?>>

    suspend fun getRefreshComics()


}