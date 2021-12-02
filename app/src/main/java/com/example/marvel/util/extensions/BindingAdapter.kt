package com.example.marvel.util.extensions

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.marvel.ui.base.BaseRecyclerAdapter

@BindingAdapter(value = ["app:items"])
fun <T> setRecyclerItems(view: RecyclerView, items: List<T>?) {
    items?.let { listItems ->
        Log.i("kk" , items.toString())
        (view.adapter as BaseRecyclerAdapter<T>?)
            ?.setItems(listItems)
    }
}

@BindingAdapter(value = ["app:imageFromUrl"])
fun setImage(view: ImageView, url: String?) {
    url?.let { imageUrl ->
        Glide.with(view)
            .load(imageUrl)
            .centerCrop()
            .into(view)
    }
}