package com.example.marvel.ui.base

import android.os.Bundle
import android.view.*
import androidx.databinding.*
import androidx.fragment.app.Fragment
import com.example.marvel.BR

abstract class BaseFragment<VB : ViewDataBinding, VM : BaseViewModel> : Fragment() {


    abstract val layoutId: Int
    lateinit var viewModel: VM
    abstract val viewModelClass: Class<VM>
    private lateinit var _binding: VB
    val binding: VB
        get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) : View? {
        _binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        _binding.apply {
            lifecycleOwner = this@BaseFragment
            setVariable(BR.viewModel, viewModel)
            return root
        }
    }

}