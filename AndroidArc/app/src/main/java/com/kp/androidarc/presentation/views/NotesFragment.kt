package com.kp.androidarc.presentation.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Lifecycling
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.kp.androidarc.R
import com.kp.androidarc.databinding.FragmentNotesBinding
import com.kp.androidarc.presentation.adapters.NotesAdapter
import com.kp.androidarc.presentation.viewmodels.HomeViewModel
import com.kp.androidarc.presentation.viewmodels.NotesViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class NotesFragment : Fragment() {
    private var _binding: FragmentNotesBinding? = null
    private val binding get() = _binding!!
    private val viewModel: NotesViewModel by viewModels()

    private lateinit var notesAdapter: NotesAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentNotesBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addNote.setOnClickListener {
            findNavController().navigate(R.id.action_NotesFragment_to_AddNotesFragment)
        }

        binding.notesList.layoutManager = LinearLayoutManager(this.context)
        notesAdapter = NotesAdapter{item ->
            val bundle = Bundle().apply {
                putParcelable("note", item) // noteModel must implement Serializable
            }
            findNavController().navigate(R.id.action_NotesFragment_to_AddNotesFragment,bundle)
        }
        binding.notesList.adapter = notesAdapter
        bindObservers()
    }

    fun bindObservers(){
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.notes.collect { noteList ->
                    notesAdapter.updateList(noteList)
                }
            }
        }
    }
}