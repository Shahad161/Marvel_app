package com.example.marvel.ui.home

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.marvel.domain.MarvelRepositoryImpl
import com.example.marvel.domain.MarvelRepository
import com.example.marvel.ui.base.BaseViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomeViewModel: BaseViewModel() {

    var repo: MarvelRepository = MarvelRepositoryImpl()

    fun jildsa(){
        viewModelScope.launch{
            repo.getCharacter().collect {
                Log.i("kkk", it.toString())
            }
        }
    }

    init {
        viewModelScope.launch {
            repo.refreshCharacters()
        }
    }

}