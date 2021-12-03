package com.example.marvel.ui.category.stories

import android.util.Log
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.marvel.domain.MarvelRepository
import com.example.marvel.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class StoriesViewModel @Inject constructor(
    private val repository: MarvelRepository
): BaseViewModel(), StoriesInteractionListener {

    val stories = repository.getStories().asLiveData(Dispatchers.IO)

    fun jildsa(){
        viewModelScope.launch{
            repository.getStories().collect {
                Log.i("jjj", it.toString())
            }
        }
    }


    init {
        viewModelScope.launch {
            repository.getRefreshStories()
        }
    }


    override fun onClickCategory() {
    }
}