package com.example.marvel.ui.home

import android.view.ViewGroup
import com.example.marvel.R
import com.example.marvel.domain.model.Comics
import com.example.marvel.ui.base.BaseRecyclerAdapter


class ComicsRecycler(
    items: List<Comics>,
    val listener: HomeInteractionListener,
) : BaseRecyclerAdapter<Comics>(items, listener) {

    override val layoutId: Int = R.layout.item_comics_nested

    override fun <T> areItemsTheSame(
        oldItemPosition: Int,
        newItemPosition: Int,
        newItems: List<T>,
    ) =
        getItems()[oldItemPosition].id == (newItems[newItemPosition] as Comics).id

}