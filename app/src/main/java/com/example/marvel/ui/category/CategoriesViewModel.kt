package com.example.marvel.ui.category

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.marvel.ui.base.BaseViewModel
import com.example.marvel.util.extensions.Event


class CategoriesViewModel: BaseViewModel(){

    private var _clickBack = MutableLiveData<Event<Boolean>>()
    val clickBack: LiveData<Event<Boolean>> = _clickBack



    fun onClickBack(){
        _clickBack.postValue(Event(true))
    }


}