package com.example.marvel.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.asLiveData
import com.example.marvel.R
import com.example.marvel.databinding.FragmentHomeBinding
import com.example.marvel.domain.MarvelRepository
import com.example.marvel.ui.base.BaseFragment
import kotlinx.coroutines.Dispatchers

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    override val viewModel: HomeViewModel by activityViewModels()
    override val layoutId: Int = R.layout.fragment_home
    override val viewModelClass = HomeViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp()
    }

    fun setUp(){
        viewModel.jildsa()
    }




}