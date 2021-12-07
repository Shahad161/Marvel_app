package com.example.marvel.ui.category

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter


class CategoriesPagerAdapter(
    container: Fragment,
    private val fragmentsList: List<Fragment>
    ): FragmentStateAdapter(container) {

    override fun getItemCount() =
        fragmentsList.size

    override fun createFragment(position: Int) =
        fragmentsList[position]

}