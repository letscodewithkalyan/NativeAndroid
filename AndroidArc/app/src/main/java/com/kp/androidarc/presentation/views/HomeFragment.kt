package com.kp.androidarc.presentation.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.kp.androidarc.R
import com.kp.androidarc.data.datasources.network.NetworkResult
import com.kp.androidarc.databinding.FragmentHomeBinding
import com.kp.androidarc.presentation.adapters.UserAdapter
import com.kp.androidarc.presentation.viewmodels.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
@AndroidEntryPoint
class HomeFragment : BaseFragment() {

    private var _binding: FragmentHomeBinding? = null
    private val viewModel: HomeViewModel by viewModels()

    private lateinit var adapter: UserAdapter

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonNotes.setOnClickListener {
            findNavController().navigate(R.id.action_HomeFragment_to_NotesFragment)
        }
        binding.recylerList.layoutManager = LinearLayoutManager(this.context)
        adapter = UserAdapter()
        binding.recylerList.adapter = adapter
        setUpObserver()
    }

    private fun setUpObserver(){
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.userData.collect {
                    when(it){
                        is NetworkResult.Success ->{
                            hideLoader()
                            adapter.updateList(it.data)
                        }

                        is NetworkResult.Error -> {
                            println(it.message)
                        }
                        NetworkResult.Loading -> {
                            showLoader()
                        }
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}