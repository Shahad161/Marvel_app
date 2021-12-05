package com.example.marvel.util.extensions

import android.view.View
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import com.example.marvel.ui.base.BaseRecyclerAdapter
import com.example.marvel.BR


fun BaseRecyclerAdapter.ItemViewHolder.setVariableAdapter(item: Any?) {
    this.binding.setVariable(BR.adapter, item)
}

fun View.goToFragment(navDir: NavDirections) {
    Navigation.findNavController(this).navigate(navDir)
}

fun <T> LiveData<Event<T>>.observeEvent(owner: LifecycleOwner, function:(T) ->Unit){
    this.observe(owner, EventObserver{ it ->
        function(it)
    })
}
