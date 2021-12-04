package com.example.marvel.ui.home

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.example.marvel.R
import com.example.marvel.ui.base.AppDiffUtil
import com.example.marvel.ui.base.BaseInteractionListener
import com.example.marvel.ui.base.BaseRecyclerAdapter
import com.example.marvel.util.extensions.setVariableAdapter


class HomeRecyclerAdapter(
    private var itemsNested: MutableList<HomeItem>,
    private val listener: HomeInteractionListener
) : BaseRecyclerAdapter<HomeItem>(itemsNested, listener) {

    override var layoutId: Int = 0

    fun addItem(newItems: HomeItem) {
        val newItemsList = itemsNested.apply {
            add(newItems)
            sortBy { item ->
                item.rank
            }
        }
        val diffResult = DiffUtil.calculateDiff(AppDiffUtil(itemsNested,
            newItemsList,
            ::areItemsTheSame,
            ::areContentSame))
        diffResult.dispatchUpdatesTo(this)
    }

    override fun <T> areItemsTheSame(
        oldItemPosition: Int,
        newItemPosition: Int,
        newItems: List<T>
    ) =
        getItems()[oldItemPosition].rank == (newItems[newItemPosition] as HomeItem).rank

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        layoutId = getLayout(viewType)
        return super.onCreateViewHolder(parent, viewType)
    }

    private fun getLayout(viewType: Int): Int =
        when (viewType) {
            TYPE_CHARACTER -> R.layout.item_characters_recycler
            TYPE_COMICS -> R.layout.item_comics_recycler
            else -> R.layout.item_series_recycler
        }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        bind(holder as ItemViewHolder, position)
    }

    private fun bind(holder: ItemViewHolder, position: Int) {
        when (val currentItem = itemsNested[position]) {
            is HomeItem.CharacterType -> {
                holder.setVariableAdapter(CharactersRecycler(currentItem.items, listener))
            }
            is HomeItem.ComicsType -> {
                holder.setVariableAdapter(ComicsRecycler((currentItem.items), listener))
            }
            is HomeItem.SeriesType -> {
                holder.setVariableAdapter(SeriesRecycler((currentItem.items), listener))
            }
        }
    }


    override fun getItemViewType(position: Int): Int =
        when (itemsNested[position]) {
            is HomeItem.CharacterType -> TYPE_CHARACTER
            is HomeItem.ComicsType -> TYPE_COMICS
            is HomeItem.SeriesType -> TYPE_SERIES

        }

    companion object {
        const val TYPE_CHARACTER = 1
        const val TYPE_COMICS = 2
        const val TYPE_SERIES = 3
    }

}

interface HomeInteractionListener : BaseInteractionListener {
    fun onClickSliderItem()
}




