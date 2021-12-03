package com.example.marvel.ui.category.series

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.example.marvel.R
import com.example.marvel.databinding.FragmentSeriesBinding
import com.example.marvel.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SeriesFragment : BaseFragment<FragmentSeriesBinding, SeriesViewModel>() {


    override val layoutId: Int = R.layout.fragment_series
    override val viewModel: SeriesViewModel by viewModels()
    override val viewModelClass = SeriesViewModel::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }



}