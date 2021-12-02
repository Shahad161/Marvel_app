package com.example.marvel.ui.comics

import android.util.Log
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.marvel.domain.MarvelRepository
import com.example.marvel.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import javax.inject.Inject

@HiltViewModel
class ComicsViewModel @Inject constructor(
    private val repository: MarvelRepository
): BaseViewModel(), ComicsInteractionListener {

    val comics =  repository.getComics().asLiveData(Dispatchers.IO)

    fun jildsa(){
        viewModelScope.launch{
            repository.getComics().collect {
                Log.i("kkk", it.toString())
            }

        }
    }

    init {
        viewModelScope.launch {
            repository.getRefreshComics()
        }
    }

    override fun onClickCategory() {

    }
}