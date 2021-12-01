package com.example.marvel.domain

import com.example.marvel.data.remote.MarvelService


object MarvelRepository {

    suspend fun getkkk() = MarvelService.apiService.getCharacters()

}