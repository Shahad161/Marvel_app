package com.example.marvel.ui.category.series

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import com.example.marvel.R
import com.example.marvel.databinding.FragmentSeriesBinding
import com.example.marvel.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SeriesFragment : BaseFragment<FragmentSeriesBinding, SeriesViewModel>() {

    override val layoutId: Int = R.layout.fragment_series
    override val viewModel: SeriesViewModel by viewModels()
    override val viewModelClass = SeriesViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp()
        viewModel.series.observe(this, {
            Log.i("ddd", it.toString())
        })
    }

    private fun setUp(){
        viewModel.jildsa()
        binding.seriesRecycler.adapter =
            SeriesRecyclerAdapter(mutableListOf(), this.viewModel)
    }


}