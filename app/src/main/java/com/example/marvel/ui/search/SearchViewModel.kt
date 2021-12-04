package com.example.marvel.ui.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.marvel.domain.MarvelRepository
import com.example.marvel.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository: MarvelRepository
): BaseViewModel() {

    val searchResult = repository.getCharacterByName().asLiveData()
    val searchName = MutableLiveData<String>()

    fun onclickSearch(){
        viewModelScope.launch {
            searchName.value?.let {
                repository.getRefreshCharacterByName(it)
            }
        }
    }

}