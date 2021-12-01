package com.example.marvel.domain

import com.example.marvel.data.remote.MarvelService
import com.example.marvel.data.remote.State
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response


object MarvelRepository {

    fun getkkk() = wrapWithFlow {  MarvelService.apiService.getCharacters()}

    private fun <T> wrapWithFlow(function: suspend () -> Response<T>): Flow<State<T?>> {
        return flow {
            emit(State.Loading)
            try {
                emit(checkIsSuccessful(function()))
            }catch (e: Exception) {
                emit(State.Error(e.message.toString()))
            }
        }
    }

    private fun <T> checkIsSuccessful(response: Response<T>): State<T?> =
        if (response.isSuccessful) {
            State.Success(response.body())
        }
        else {
            State.Error(response.message())
        }

}