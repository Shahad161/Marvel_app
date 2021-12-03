package com.example.marvel.ui.category

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.marvel.R
import com.example.marvel.databinding.FragmentCategoriesBinding
import com.example.marvel.ui.base.BaseFragment
import com.example.marvel.ui.base.BaseViewModel
import com.example.marvel.ui.category.series.SeriesFragment
import com.example.marvel.ui.category.stories.StoriesFragment
import com.example.marvel.util.extensions.Constants
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@AndroidEntryPoint
class CategoriesFragment : BaseFragment<FragmentCategoriesBinding, CategoriesViewModel>() {

    override val layoutId: Int = R.layout.fragment_categories
    override val viewModel: CategoriesViewModel by viewModels()
    override val viewModelClass = CategoriesViewModel::class.java

    private val fragmentsList = listOf(StoriesFragment(), SeriesFragment())

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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


}