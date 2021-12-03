package com.example.marvel.ui.category.stories

import com.example.marvel.R
import com.example.marvel.domain.model.Stories
import com.example.marvel.ui.base.*


class StoriesRecyclerAdapter(
    items: List<Stories>,
    private val listener: StoriesInteractionListener
) : BaseRecyclerAdapter<Stories>(items, listener) {
    override val layoutId: Int = R.layout.item_stories

    override fun <T> areItemsTheSame(
        oldItemPosition: Int,
        newItemPosition: Int,
        newItems: List<T>
    ) =
        getItems()[oldItemPosition] == (newItems[newItemPosition] as Stories)
}

interface StoriesInteractionListener: BaseInteractionListener {

    fun onClickCategory()

}