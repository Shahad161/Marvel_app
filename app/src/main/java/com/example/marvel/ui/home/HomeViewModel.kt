package com.example.marvel.ui.home

import android.util.Log
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.marvel.data.remote.State
import com.example.marvel.domain.*
import com.example.marvel.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject



@HiltViewModel
class HomeViewModel @Inject constructor(
    var repository: MarvelRepository
): BaseViewModel(),HomeInteractionListener {

    var characters = repository.getCharacter().asLiveData()
    var comics = repository.getComics().asLiveData()
    var series = repository.getSeries().asLiveData()


    init{
        viewModelScope.launch {
            repository.getRefreshComics()
            repository.getRefreshSeries()
            repository.getRefreshCharacters()
        }
    }

    val state= MediatorLiveData<State<Any>>().apply {
        addSource(characters,this@HomeViewModel::checkIfSuccess)
        addSource(comics, this@HomeViewModel::checkIfSuccess)
        addSource(series, this@HomeViewModel::checkIfSuccess)

    }


    private fun <T>checkIfSuccess(currentState:State<T>){
        if(currentState is State.Success){
            state.postValue(currentState as State<Any>)
        }
    }

    override fun onClickSliderItem() {
    }

}