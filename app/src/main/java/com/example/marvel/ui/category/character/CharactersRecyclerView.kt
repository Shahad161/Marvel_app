package com.example.marvel.ui.category.character

import com.example.marvel.R
import com.example.marvel.domain.model.Characters
import com.example.marvel.ui.base.BaseInteractionListener
import com.example.marvel.ui.base.BaseRecyclerAdapter


class CharactersRecyclerView(
    items: List<Characters>,
    private val listener: CharactersInteractionListener
) : BaseRecyclerAdapter<Characters>(items, listener) {
    override val layoutId: Int = R.layout.item_characters

    override fun <T> areItemsTheSame(
        oldItemPosition: Int,
        newItemPosition: Int,
        newItems: List<T>
    ) =
        getItems()[oldItemPosition] == (newItems[newItemPosition] as Characters)

}

interface CharactersInteractionListener: BaseInteractionListener { }