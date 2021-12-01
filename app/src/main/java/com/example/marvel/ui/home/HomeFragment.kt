package com.example.marvel.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.asLiveData
import com.example.marvel.R
import com.example.marvel.databinding.FragmentHomeBinding
import com.example.marvel.domain.MarvelRepository
import com.example.marvel.ui.base.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    override val layoutId: Int = R.layout.fragment_home
    override val viewModelClass: Class<HomeViewModel> = HomeViewModel::class.java

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        setUp()
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    fun setUp(){
        Log.i("kkk", MarvelRepository.getkkk().asLiveData().value.toString())
    }


}