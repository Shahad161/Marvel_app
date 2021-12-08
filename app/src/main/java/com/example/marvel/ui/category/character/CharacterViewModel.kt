package com.example.marvel.ui.category.character

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.marvel.domain.MarvelRepository
import com.example.marvel.ui.base.BaseViewModel
import com.example.marvel.util.extensions.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val repository: MarvelRepository
): BaseViewModel(), CharactersInteractionListener {

    val characters =  repository.getCharacter().asLiveData()

    private var _clickBack = MutableLiveData<Event<Boolean>>()
    val clickBack: LiveData<Event<Boolean>> = _clickBack



    init {
        viewModelScope.launch {
            repository.getRefreshCharacters()
        }
    }


    fun onClickBack(){
        _clickBack.postValue(Event(true))
    }


}