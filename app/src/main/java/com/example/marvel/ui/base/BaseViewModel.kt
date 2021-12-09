package com.example.marvel.ui.base

import androidx.lifecycle.*
import com.example.marvel.data.remote.State
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.*

abstract class BaseViewModel: ViewModel() {

    fun <T> collectResponse(flow: Flow<State<T>>, function: (State<T?>) -> Unit) {

        viewModelScope.launch {
            flow.flowOn(Dispatchers.IO)
                .collect { state ->
                    function(state)
                }
        }
    }


}