package com.example.marvel.ui.base

import android.view.*
import androidx.databinding.*
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.marvel.BR
import dagger.hilt.android.AndroidEntryPoint


abstract class BaseRecyclerAdapter<T>(
    private var items: List<T>,
    private val listener: BaseInteractionListener,
): RecyclerView.Adapter<BaseRecyclerAdapter.BaseViewHolder>(){

    abstract val layoutId: Int

    abstract fun <T> areItemsTheSame(
        oldItemPosition: Int,
        newItemPosition: Int,
        newItems: List<T>,
    ): Boolean

    open fun areContentSame(oldPosition: Int, newPosition: Int, newList: List<T>) = true

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): BaseViewHolder =
        ItemViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                layoutId,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        when(holder){
            is ItemViewHolder -> {
                holder.binding.apply {
                    setVariable(BR.item,items[position])
                    setVariable(BR.listener, listener)
                }
            }
        }
    }

    override fun getItemCount(): Int = items.size

    fun setItems(newItems: List<T>?){
        items = newItems!!
        notifyDataSetChanged()

    }

    fun getItems() = items

    abstract class BaseViewHolder(binding: ViewDataBinding)
        : RecyclerView.ViewHolder(binding.root)

    open class ItemViewHolder(val binding: ViewDataBinding)
        : BaseViewHolder(binding)

}

interface BaseInteractionListener
