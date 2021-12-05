package com.example.marvel.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import com.example.marvel.R
import com.example.marvel.databinding.FragmentHomeBinding
import com.example.marvel.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint



@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    override val viewModel: HomeViewModel by viewModels()
    override val layoutId: Int = R.layout.fragment_home
    override val viewModelClass = HomeViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            homeRecycler.adapter =
                HomeRecyclerAdapter(mutableListOf(), this@HomeFragment.viewModel)
        }
        setUp()

    }

    private fun setUp() {
        viewModel.apply {
            (binding.homeRecycler.adapter as HomeRecyclerAdapter?)?.apply {
                addItem(characters) {
                    addItem(HomeItem.CharacterType(it))
                }

                addItem(comics) {
                    addItem(HomeItem.ComicsType(it))
                }

                addItem(series) {
                    addItem(HomeItem.SeriesType(it))
                }
            }
        }
    }

    private fun <T>addItem(
        response : LiveData<T>,
        add: (T) -> Unit
    ){
        (binding.homeRecycler.adapter as HomeRecyclerAdapter?)?.apply {
            response.observe(this@HomeFragment) {
                add(it)
            }
        }
    }

}