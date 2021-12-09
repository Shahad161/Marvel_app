package com.example.marvel.ui.category.series

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.marvel.data.remote.State
import com.example.marvel.data.remote.respons.BaseResponse
import com.example.marvel.data.remote.respons.SeriesDto
import com.example.marvel.data.remote.respons.comics.ComicsDto
import com.example.marvel.domain.MarvelRepository
import com.example.marvel.domain.model.Item
import com.example.marvel.ui.base.BaseViewModel
import com.example.marvel.util.extensions.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SeriesViewModel @Inject constructor(
    private val repository: MarvelRepository
): BaseViewModel(), SeriesInteractionListener {

    private val _series = MutableLiveData<State<List<Item>>>()
    val series: LiveData<State<List<Item>>> = _series

    private val _loading = MutableLiveData<State<Item?>>()
    val loading: LiveData<State<Item?>> = _loading

    private var _clickBack = MutableLiveData<Event<Boolean>>()
    val clickBack: LiveData<Event<Boolean>> = _clickBack


    init {
        viewModelScope.launch {
            repository.getRefreshSeries()
            repository.getSeriesResponse().collect {
                _series.postValue(it)
            }
        }
    }


    fun requestMoreProducts() {
        getProductsInCurrentPage { state ->
            when (state) {
                is State.Error, State.Loading -> {
                    _loading.postValue(state)
                }
                is State.Success -> {
                    state.toData()?.apply {
                        mutableListOf(this).addAll(0,  _series.value?.toData() ?: mutableListOf())
                    }
                    _series.postValue(State.Success(listOf(state.data!!)))
                    _loading.postValue(state)
                }
            }
        }
    }

    private fun getProductsInCurrentPage(onResponse: (State<Item?>) -> Unit) {
        collectResponse(
            repository.getComicsResponse(), onResponse
        )
    }


    fun onClickBack(){
        _clickBack.postValue(Event(true))
    }


}