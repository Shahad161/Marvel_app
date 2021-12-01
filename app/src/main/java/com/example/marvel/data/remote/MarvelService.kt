package com.example.marvel.data.remote

import com.example.marvel.BuildConfig
import com.example.marvel.data.remote.respons.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface MarvelService {

    @GET("characters")
    suspend fun getCharacters():Response<BaseResponse<CharacterDto>>


    companion object{
        private val client = OkHttpClient
            .Builder()
            .addInterceptor(HttpLoggingInterceptor()
                .apply{ setLevel(HttpLoggingInterceptor.Level.BODY)})
            .addInterceptor(AuthInterceptor())
            .build()

        private val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        val apiService = retrofit.create(MarvelService::class.java)
    }
}