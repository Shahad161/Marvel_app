package com.example.marvel.ui.search

import com.example.marvel.R
import com.example.marvel.ui.base.*
import com.example.marvel.domain.model.Characters


class SearchRecyclerAdapter(
    items: List<Characters>,
    private val listener: SearchInteractionListener
) : BaseRecyclerAdapter<Characters>(items, listener) {
    override val layoutId: Int = R.layout.item_series

    override fun <T> areItemsTheSame(
        oldItemPosition: Int,
        newItemPosition: Int,
        newItems: List<T>
    ) =
        getItems()[oldItemPosition] == (newItems[newItemPosition] as Characters)
}

interface SearchInteractionListener: BaseInteractionListener {
    fun onClickCategory()
}