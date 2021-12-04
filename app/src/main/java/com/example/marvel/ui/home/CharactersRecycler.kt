package com.example.marvel.ui.home

import com.example.marvel.R
import com.example.marvel.domain.model.Characters
import com.example.marvel.ui.base.BaseRecyclerAdapter


class CharactersRecycler(
    items: List<Characters>,
    val listener: HomeInteractionListener,
): BaseRecyclerAdapter<Characters>(items, listener) {

    override val layoutId: Int = R.layout.item_characters

    override fun <T> areItemsTheSame(
        oldItemPosition: Int,
        newItemPosition: Int,
        newItems: List<T>,
    ) =
        getItems()[oldItemPosition].id == (newItems[newItemPosition] as Characters).id

}