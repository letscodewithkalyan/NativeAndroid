package com.example.mynotes.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mynotes.R
import com.example.mynotes.databinding.FragmentPokeManBinding
import com.example.mynotes.utils.NetworkResult
import com.example.mynotes.viewmodels.PokeManViewModel
import kotlinx.coroutines.flow.collect

class PokeManFragment : Fragment() {

    private var _binding: FragmentPokeManBinding? = null
    private val binding get() = _binding!!

    private val viewModel by activityViewModels<PokeManViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPokeManBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getData()
        binding.pokeManList.layoutManager = GridLayoutManager(context, 2)

        bindObservers()
    }

    fun bindObservers(){
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.pokeManResult.collect{
                when(it){
                    is NetworkResult.Success ->{

                    }
                    is NetworkResult.Loading ->{

                    }
                    is NetworkResult.Error ->{
                        
                    }
                }
            }
        }
    }
}