package com.example.marvel.util.extensions

import com.example.marvel.ui.base.BaseRecyclerAdapter
import com.example.marvel.BR


fun BaseRecyclerAdapter.ItemViewHolder.setVariableAdapter(item: Any?) {
    this.binding.setVariable(BR.adapter, item)
}
