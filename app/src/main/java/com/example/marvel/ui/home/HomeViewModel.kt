package com.example.marvel.ui.home

import android.util.Log
import androidx.lifecycle.asFlow
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.marvel.domain.MarvelRepository
import com.example.marvel.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class HomeViewModel: BaseViewModel() {


    fun jildsa(){
        viewModelScope.launch{
            Log.i("kkk", MarvelRepository.getkkk().body().toString())
        }
    }

}