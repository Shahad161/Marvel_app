package com.example.marvel.ui.home

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.marvel.domain.*
import com.example.marvel.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    var repository: MarvelRepository
): BaseViewModel() {

//    fun jildsa(){
//        viewModelScope.launch{
//            repository.getComics().collect {
//                Log.i("kkk", it.toString())
//            }
//        }
//    }
}