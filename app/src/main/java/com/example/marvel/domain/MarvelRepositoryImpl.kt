package com.example.marvel.domain

import com.example.marvel.data.local.MarvelDataBase
import com.example.marvel.data.local.entity.CharactersEntity
import com.example.marvel.data.remote.MarvelService
import com.example.marvel.data.remote.respons.*
import com.example.marvel.data.remote.State
import kotlinx.coroutines.flow.*
import retrofit2.Response

class MarvelRepositoryImpl: MarvelRepository {

    val apiService = MarvelService.apiService
    val charactersDao = MarvelDataBase.getInstance().MarvelDao()

    override fun getCharacter(): Flow<List<CharactersEntity>> =
        charactersDao.getCharacters()


    override suspend fun refreshCharacters() {
        val item =apiService.getCharacters().body()?.dataContainer?.items?.map {
            CharactersEntity(
                id = it.id?.toLong() ?: 0L,
                name = it.name ?: "",
                description = it.description ?: "",
                modified = it.modified ?: "",
                imgUrl = "${it.thumbnail?.path}.${it.thumbnail?.extension} ?: 0 "
            )
        }
        item?.let { charactersDao.insertCharacters(it) }
    }

//    fun <T> wrapWithFlow(function: suspend () -> Response<T>): Flow<State<T?>> {
//        return flow {
//            emit(State.Loading)
//            try {
//                emit(checkIsSuccessful(function()))
//            }catch (e: Exception) {
//                emit(State.Error(e.message.toString()))
//            }
//        }
//    }
//
//    private fun <T> checkIsSuccessful(response: Response<T>): State<T?> =
//        if (response.isSuccessful) {
//            State.Success(response.body())
//        }
//        else {
//            State.Error(response.message())
//        }
}