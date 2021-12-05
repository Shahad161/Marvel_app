package com.example.marvel.ui.category.series

import android.util.Log
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.marvel.domain.MarvelRepository
import com.example.marvel.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SeriesViewModel @Inject constructor(
    private val repository: MarvelRepository
): BaseViewModel(), SeriesInteractionListener {

    val series = repository.getSeries().asLiveData()

    fun jildsa(){
        viewModelScope.launch{
            repository.getSeries().collect {
                Log.i("aaa", it.toString())
            }
        }
    }

    init {
        viewModelScope.launch {
            repository.getRefreshSeries()
        }
    }

    override fun onClickCategory() {

    }

}