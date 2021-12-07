package com.example.marvel.ui.category.comics

import com.example.marvel.R
import com.example.marvel.domain.model.Comics
import com.example.marvel.ui.base.BaseInteractionListener
import com.example.marvel.ui.base.BaseRecyclerAdapter

class ComicsRecyclerAdapter(
    items: List<Comics>,
    private val listener: ComicsInteractionListener
) : BaseRecyclerAdapter<Comics>(items, listener) {
    override val layoutId: Int = R.layout.item_comics

    override fun <T> areItemsTheSame(
        oldItemPosition: Int,
        newItemPosition: Int,
        newItems: List<T>
    ) =
        getItems()[oldItemPosition] == (newItems[newItemPosition] as Comics)

}

interface ComicsInteractionListener: BaseInteractionListener {

    fun onClickCategory()

}