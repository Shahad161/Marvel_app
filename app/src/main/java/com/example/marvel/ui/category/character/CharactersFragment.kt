package com.example.marvel.ui.category.character


import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.marvel.R
import com.example.marvel.databinding.FragmentCharactersBinding
import com.example.marvel.ui.base.BaseFragment
import com.example.marvel.util.extensions.observeEvent
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CharactersFragment : BaseFragment<FragmentCharactersBinding, CharacterViewModel>() {

    override val layoutId: Int = R.layout.fragment_characters
    override val viewModel: CharacterViewModel by viewModels()
    override val viewModelClass = CharacterViewModel::class.java


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeEvents()
        setUp()
    }


    private fun setUp(){
        binding.charactersRecycler.adapter =
            CharactersRecyclerView(mutableListOf(), this.viewModel)
    }


    private fun observeEvents(){
        viewModel.clickBack.observeEvent(this) {
            findNavController().navigateUp()
        }
    }

}