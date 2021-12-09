package com.example.marvel.ui.category.comics

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.marvel.domain.MarvelRepository
import com.example.marvel.ui.base.BaseViewModel
import com.example.marvel.util.extensions.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ComicsViewModel @Inject constructor(
    private val repository: MarvelRepository
): BaseViewModel(), ComicsInteractionListener {

    val comics =  repository.getComics().asLiveData(Dispatchers.IO)

    private var _clickBack = MutableLiveData<Event<Boolean>>()
    val clickBack: LiveData<Event<Boolean>> = _clickBack



    init {
        viewModelScope.launch {
            repository.getRefreshComics()
        }
    }

    fun onClickBack(){
        _clickBack.postValue(Event(true))
    }


}