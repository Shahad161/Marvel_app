package com.example.marvel.data.remote

import com.example.marvel.BuildConfig
import com.example.marvel.util.extensions.md5
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val timestamp = System.currentTimeMillis().toString()
        val apikey = BuildConfig.PUBLIC_KEY_PARAM
        val hash = "$timestamp${BuildConfig.PRIVATE_KEY_PARAM}$apikey".md5()

        with(chain.request()){
            url.newBuilder().apply {

                addQueryParameter(TIMESTAMP_PARAM, timestamp)
                addQueryParameter(API_KEY_PARAM, apikey)
                addQueryParameter(HASH_PARAM, hash)

            }.build().also {
                return chain.proceed(this.newBuilder().url(it).build())
            }
        }
    }

    companion object{
        private const val API_KEY_PARAM = "apikey"
        private const val TIMESTAMP_PARAM = "ts"
        private const val HASH_PARAM = "hash"

    }

}