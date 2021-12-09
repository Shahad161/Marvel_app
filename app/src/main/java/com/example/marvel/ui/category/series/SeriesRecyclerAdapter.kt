package com.example.marvel.ui.category.series

import com.example.marvel.R
import com.example.marvel.domain.model.Item
import com.example.marvel.ui.base.BaseInteractionListener
import com.example.marvel.ui.base.BaseRecyclerAdapter


class SeriesRecyclerAdapter(
    items: List<Item>,
    private val listener: SeriesInteractionListener
) : BaseRecyclerAdapter<Item>(items, listener) {
    override val layoutId: Int = R.layout.item_series

    override fun <T> areItemsTheSame(
        oldItemPosition: Int,
        newItemPosition: Int,
        newItems: List<T>
    ) =
        getItems()[oldItemPosition] == (newItems[newItemPosition] as Item)
}

interface SeriesInteractionListener: BaseInteractionListener { }