package com.example.marvel.data.remote

import com.example.marvel.data.remote.respons.*
import com.example.marvel.data.remote.respons.comics.ComicsDto
import retrofit2.http.GET
import retrofit2.*
import retrofit2.http.Query


interface MarvelService {

    @GET("characters")
    suspend fun getCharacters(): Response<BaseResponse<CharacterDto>>

    @GET("comics")
    suspend fun getComics(): Response<BaseResponse<ComicsDto>>

    @GET("series")
    suspend fun getSeries(): Response<BaseResponse<SeriesDto>>


    @GET("characters")
    suspend fun getCharacterByName(
        @Query("name") name: String,
        ): Response<BaseResponse<CharacterDto>>

}