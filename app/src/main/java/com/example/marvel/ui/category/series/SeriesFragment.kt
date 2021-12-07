package com.example.marvel.ui.category.series

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.marvel.R
import com.example.marvel.databinding.FragmentSeriesBinding
import com.example.marvel.ui.base.BaseFragment
import com.example.marvel.util.extensions.observeEvent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SeriesFragment : BaseFragment<FragmentSeriesBinding, SeriesViewModel>() {

    override val layoutId: Int = R.layout.fragment_series
    override val viewModel: SeriesViewModel by viewModels()
    override val viewModelClass = SeriesViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeEvents()
        setUp()
    }


    private fun setUp(){
        binding.seriesRecycler.adapter =
            SeriesRecyclerAdapter(mutableListOf(), this.viewModel)
    }


    private fun observeEvents(){
        viewModel.clickBack.observeEvent(this) {
            findNavController().navigateUp()
        }
    }


}