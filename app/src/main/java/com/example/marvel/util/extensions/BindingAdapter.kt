package com.example.marvel.util.extensions

import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.marvel.ui.base.BaseRecyclerAdapter


@BindingAdapter(value = ["app:items"])
fun <T> setRecyclerItems(view: RecyclerView, items: List<T>?) {
    items?.let { listItems ->
        (view.adapter as BaseRecyclerAdapter<T>?)
            ?.setItems(listItems)
    }
}

@BindingAdapter(value = ["app:imageFromUrl"])
fun setImage(view: ImageView, url: String?) {
    view.load(url)
}

@BindingAdapter(value = ["app:onclickSearch"])
fun onclickSearch(view: EditText, function: () -> Unit) {
    view.setOnEditorActionListener { _, _, _ ->
        function()
        return@setOnEditorActionListener false
    }
}

@BindingAdapter(value = ["app:isNotNull"])
fun <T> isNotNull(view: View, list: T?) {
    view.isVisible = (list != null)
}


@BindingAdapter(value = ["app:visibility"])
fun <T> visibility(view: View, value: Boolean?) {
    view.isVisible = value == true
}

