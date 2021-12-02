package com.example.marvel.data.remote

import com.example.marvel.data.remote.respons.*
import com.example.marvel.data.remote.respons.comics.ComicsDto
import retrofit2.http.GET
import retrofit2.*


interface MarvelService {

    @GET("characters")
    suspend fun getCharacters(): Response<BaseResponse<CharacterDto>>

    @GET("comics")
    suspend fun getComics(): Response<BaseResponse<ComicsDto>>
}