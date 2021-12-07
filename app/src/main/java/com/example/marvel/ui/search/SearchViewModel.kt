package com.example.marvel.ui.search

import androidx.lifecycle.*
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

    val searchRecentResult = repository.getCharacterRecentSearch().asLiveData()
    val searchResult = MutableLiveData<List<SearchCharacterResult>>()

    private var _clickBack = MutableLiveData<Event<Boolean>>()
    val clickBack: LiveData<Event<Boolean>> = _clickBack

    private var _notFound = MutableLiveData(false)
    val notFound: LiveData<Boolean> = _notFound

    private var _recentSearch= MutableLiveData(true)
    val recentSearch: LiveData<Boolean> = _recentSearch

    private var _clickItem= MutableLiveData<Event<Int>>()
    val clickItem: LiveData<Event<Int>> = _clickItem


    val searchName = MutableLiveData<String>()
    private var isExist = MutableLiveData<Boolean>()



    fun onclickSearch(){
        viewModelScope.launch {
            checkIfItemInDataBase()
            searchName.value?.let { name ->
                if (isExist.value == true){
                    repository.getCharacterSearchByName(name.lowercase()).collect {
                        searchResult.postValue(it) }
                }
                else{
                    repository.getRefreshCharacterSearch(name.lowercase())
                    searchName.value?.let { repository.getCharacterSearchByName(name.lowercase()) }?.collect {
                        searchResult.postValue(it)
                        checkIfItemExist(it)
                    }
                }
            }
        }
    }

    private fun  checkIfItemExist(list: List<SearchCharacterResult>) {
        _recentSearch.postValue(false)
        if (list.isNullOrEmpty())
            _notFound.postValue(true)
        else
            _notFound.postValue(false)

    }

    private fun checkIfItemInDataBase(){
        viewModelScope.launch {
            searchName.value?.let { repository
                .getCharacterSearchByName(it) }?.collect {
                if(it.isNullOrEmpty()) {
                    isExist.postValue(false)
                }
                else
                    isExist.postValue(true)
            }
        }
    }



    fun onClickBack(){
        _clickBack.postValue(Event(true))
    }

    override fun onClickRecentItem(name: String) {
        searchName.value = name
        onclickSearch()
    }


}