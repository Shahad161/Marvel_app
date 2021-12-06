package com.example.marvel.ui.search

import com.example.marvel.R
import com.example.marvel.ui.base.*
import com.example.marvel.domain.model.SearchCharacterResult


class SearchRecentRecyclerAdapter(
    items: List<SearchCharacterResult>,
    listener: SearchInteractionListener
) : BaseRecyclerAdapter<SearchCharacterResult>(items, listener) {
    override val layoutId: Int = R.layout.item_search_recent

    override fun <T> areItemsTheSame(
        oldItemPosition: Int,
        newItemPosition: Int,
        newItems: List<T>
    ) =
        getItems()[oldItemPosition] == (newItems[newItemPosition] as SearchCharacterResult)
}
