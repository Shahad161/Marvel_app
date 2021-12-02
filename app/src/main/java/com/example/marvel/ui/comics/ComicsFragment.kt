package com.example.marvel.ui.comics

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.marvel.R
import com.example.marvel.databinding.FragmentComicsBinding
import com.example.marvel.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ComicsFragment: BaseFragment<FragmentComicsBinding, ComicsViewModel>() {

    override val viewModel: ComicsViewModel by viewModels()
    override val layoutId: Int = R.layout.fragment_comics
    override val viewModelClass = ComicsViewModel::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp()

    }

    private fun setUp(){
        viewModel.jildsa()
        binding.comicsRecycler.adapter =
            ComicsRecyclerAdapter(mutableListOf(), this.viewModel)
    }

}