package com.example.marvel.ui.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.marvel.data.remote.State
import com.example.marvel.domain.MarvelRepository
import com.example.marvel.domain.model.SearchCharacterResult
import com.example.marvel.ui.base.BaseViewModel
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

    override fun onClickCategory() {

    }

}