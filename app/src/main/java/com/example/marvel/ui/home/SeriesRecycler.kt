package com.example.marvel.ui.home

import com.example.marvel.R
import com.example.marvel.domain.model.Series
import com.example.marvel.ui.base.BaseRecyclerAdapter


class SeriesRecycler(
    items: List<Series>,
    val listener: HomeInteractionListener,
) : BaseRecyclerAdapter<Series>(items, listener) {

    override val layoutId: Int = R.layout.item_series_nested

    override fun <T> areItemsTheSame(
        oldItemPosition: Int,
        newItemPosition: Int,
        newItems: List<T>,
    ) =
        getItems()[oldItemPosition].id == (newItems[newItemPosition] as Series).id

}