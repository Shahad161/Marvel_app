package com.example.marvel.ui.home

import androidx.lifecycle.*
import com.example.marvel.domain.*
import com.example.marvel.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    var repository: MarvelRepository
): BaseViewModel(), HomeInteractionListener {

    var characters = repository.getCharacter().asLiveData(Dispatchers.IO)
    var comics = repository.getComics().asLiveData()
    var series = repository.getSeries().asLiveData()


    init{
        viewModelScope.launch {
            repository.getRefreshComics()
            repository.getRefreshSeries()
            repository.getRefreshCharacters()
        }
    }

    val data = MediatorLiveData<Any>().apply {
        addSource(characters, this@HomeViewModel::checkIfNull)
        addSource(comics, this@HomeViewModel::checkIfNull)
        addSource(series, this@HomeViewModel::checkIfNull)
    }


    private fun <T> checkIfNull(currentData: T){
        if (currentData != null)
            data.postValue(currentData)
    }


    override fun onClickSliderItem() { }

}