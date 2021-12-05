package com.example.marvel.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.marvel.data.remote.State
import com.example.marvel.domain.MarvelRepository
import com.example.marvel.domain.model.SearchCharacterResult
import com.example.marvel.ui.base.BaseViewModel
import com.example.marvel.util.extensions.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository: MarvelRepository
): BaseViewModel(), SearchInteractionListener {

    val searchRecentResult = repository.getCharacterByName().asLiveData()
    val searchResult = MutableLiveData<State<List<SearchCharacterResult>>>()

    private var _clickBack = MutableLiveData<Event<Boolean>>()
    val clickBack: LiveData<Event<Boolean>> = _clickBack

    val searchName = MutableLiveData<String>()
    var isExist = MutableLiveData<Boolean>()



    fun onclickSearch(){
        viewModelScope.launch {
            checkIfItemInDataBase()
            if (isExist.value == true){
                searchName.value?.let {
                    repository.getRefreshCharacterByName(it)
                }
            }
            else {

                searchName.value?.let { repository.getLastCharacterByName(it) }?.collect {
                    searchResult.postValue(it)
                }
            }
        }
    }

    private suspend fun checkIfItemInDataBase(){
        searchName.value?.let { repository.getLastCharacterByName(it) }?.collect {
            if(!it.toData().isNullOrEmpty())
                 isExist.postValue(false)
            else isExist.postValue(true)
        }
    }

    fun onClickBack(){
        _clickBack.postValue(Event(true))
    }


    override fun onClickCategory() {}

}