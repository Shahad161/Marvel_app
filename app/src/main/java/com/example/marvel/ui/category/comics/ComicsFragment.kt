package com.example.marvel.ui.category.comics

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.marvel.R
import com.example.marvel.databinding.FragmentComicsBinding
import com.example.marvel.ui.base.BaseFragment
import com.example.marvel.util.extensions.observeEvent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ComicsFragment: BaseFragment<FragmentComicsBinding, ComicsViewModel>() {

    override val viewModel: ComicsViewModel by viewModels()
    override val layoutId: Int = R.layout.fragment_comics
    override val viewModelClass = ComicsViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeEvents()
        setUp()
    }


    private fun setUp(){
        binding.comicsRecycler.adapter =
            ComicsRecyclerAdapter(mutableListOf(), this.viewModel)
    }


    private fun observeEvents(){
        viewModel.clickBack.observeEvent(this) {
            findNavController().navigateUp()
        }
    }



}