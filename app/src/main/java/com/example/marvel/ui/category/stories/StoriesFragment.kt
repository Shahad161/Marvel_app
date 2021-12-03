package com.example.marvel.ui.category.stories

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.marvel.R
import com.example.marvel.databinding.FragmentStoriesBinding
import com.example.marvel.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StoriesFragment : BaseFragment<FragmentStoriesBinding, StoriesViewModel>() {

    override val layoutId: Int = R.layout.fragment_stories
    override val viewModel: StoriesViewModel by viewModels()
    override val viewModelClass = StoriesViewModel::class.java


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp()
    }

    private fun setUp(){
        viewModel.jildsa()
        binding.storiesRecycler.adapter =
            StoriesRecyclerAdapter(mutableListOf(), this.viewModel)
    }

}