package com.example.marvel.ui.category.stories

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.marvel.R
import com.example.marvel.databinding.FragmentStoriesBinding
import com.example.marvel.ui.base.BaseFragment


class StoriesFragment : BaseFragment<FragmentStoriesBinding, StoriesViewModel>() {

    override val layoutId: Int = R.layout.fragment_stories
    override val viewModel: StoriesViewModel by viewModels()
    override val viewModelClass = StoriesViewModel::class.java


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


}