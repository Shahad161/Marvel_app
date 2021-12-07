package com.example.marvel.ui.category.series

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.marvel.domain.MarvelRepository
import com.example.marvel.ui.base.BaseViewModel
import com.example.marvel.util.extensions.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SeriesViewModel @Inject constructor(
    private val repository: MarvelRepository
): BaseViewModel(), SeriesInteractionListener {

    val series = repository.getSeries().asLiveData()

    private var _clickBack = MutableLiveData<Event<Boolean>>()
    val clickBack: LiveData<Event<Boolean>> = _clickBack


    init {
        viewModelScope.launch {
            repository.getRefreshSeries()
        }
    }


    fun onClickBack(){
        _clickBack.postValue(Event(true))
    }

    override fun onClickCategory() {

    }


}