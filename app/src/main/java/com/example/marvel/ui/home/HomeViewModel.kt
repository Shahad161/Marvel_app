package com.example.marvel.ui.home

import androidx.lifecycle.*
import com.example.marvel.domain.*
import com.example.marvel.ui.base.BaseViewModel
import com.example.marvel.util.extensions.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    var repository: MarvelRepository
): BaseViewModel(), HomeInteractionListener {

    var characters = repository.getCharacter().asLiveData()
    var comics = repository.getComics().asLiveData()
    var series = repository.getSeries().asLiveData()

    private var _clickSearch = MutableLiveData<Event<Boolean>>()
    val clickSearch: LiveData<Event<Boolean>> = _clickSearch


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


    fun onClickSearch(){
        _clickSearch.postValue(Event(true))
    }


    override fun onClickSliderItem() { }

}