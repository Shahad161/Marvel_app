package com.example.marvel.domain

import com.example.marvel.data.local.entity.ComicsEntity
import com.example.marvel.data.remote.State
import com.example.marvel.domain.model.Characters
import kotlinx.coroutines.flow.Flow


interface MarvelRepository{

    fun getCharacter(): Flow<State<List<Characters>?>>

    fun getComics(): Flow<List<ComicsEntity>?>

    suspend fun getRefreshComics()


}