package com.example.marvel.ui.category

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.marvel.R
import com.example.marvel.databinding.FragmentCategoriesBinding
import com.example.marvel.ui.base.BaseFragment
import com.example.marvel.ui.category.comics.ComicsFragment
import com.example.marvel.ui.category.series.SeriesFragment
import com.example.marvel.ui.search.SearchFragmentDirections
import com.example.marvel.util.extensions.Constants
import com.example.marvel.util.extensions.goToFragment
import com.example.marvel.util.extensions.observeEvent
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint



@AndroidEntryPoint
class CategoriesFragment : BaseFragment<FragmentCategoriesBinding, CategoriesViewModel>() {

    override val layoutId: Int = R.layout.fragment_categories
    override val viewModel: CategoriesViewModel by viewModels()
    override val viewModelClass = CategoriesViewModel::class.java
    private val fragmentsList = listOf(ComicsFragment(), SeriesFragment())


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeEvents()
        setUp()
    }

    private fun setUp() {
        initViewPager()
        initTabLayout()
    }

    private fun initTabLayout() {
        TabLayoutMediator(binding.tabLayout, binding.viewPager){ tab, position ->
            tab.text = Constants.TAB_TITLES[position]
        }.attach()
    }

    private fun initViewPager() {
        binding.viewPager.apply {
            adapter = CategoriesPagerAdapter(this@CategoriesFragment, fragmentsList)
            isUserInputEnabled = false
        }
    }

    private fun observeEvents(){
        viewModel.clickBack.observeEvent(this) {
            view?.goToFragment(CategoriesFragmentDirections.actionCategoriesFragmentToHomeFragment())
        }
    }

}