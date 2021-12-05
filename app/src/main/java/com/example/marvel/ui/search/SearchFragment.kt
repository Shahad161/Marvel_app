package com.example.marvel.ui.search

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.marvel.R
import com.example.marvel.databinding.FragmentSearchBinding
import com.example.marvel.ui.base.BaseFragment
import com.example.marvel.ui.home.HomeFragmentDirections
import com.example.marvel.util.extensions.goToFragment
import com.example.marvel.util.extensions.observeEvent
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SearchFragment : BaseFragment<FragmentSearchBinding, SearchViewModel>() {
    override val layoutId: Int = R.layout.fragment_search
    override val viewModel: SearchViewModel by viewModels()
    override val viewModelClass = SearchViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp()
        observeEvents()
    }

    private fun setUp(){
        binding.searchRecycler.adapter =
            SearchRecyclerAdapter(mutableListOf(), this.viewModel)

        binding.searchRecentRecycler.adapter =
            SearchRecentRecyclerAdapter(mutableListOf(), this.viewModel)
    }

    private fun observeEvents(){
        viewModel.clickBack.observeEvent(this) {
            view?.goToFragment(SearchFragmentDirections.actionSearchFragmentToHomeFragment())
        }
    }


}
