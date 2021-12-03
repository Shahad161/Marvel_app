package com.example.marvel.ui.search

import androidx.lifecycle.MutableLiveData
import com.example.marvel.domain.MarvelRepository
import com.example.marvel.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository: MarvelRepository
): BaseViewModel() {

    val searchName = MutableLiveData<String>()

    fun onclickSearch(){
    }

}