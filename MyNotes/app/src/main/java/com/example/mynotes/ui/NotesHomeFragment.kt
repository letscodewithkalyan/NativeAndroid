package com.example.mynotes.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mynotes.R
import com.example.mynotes.adapters.NoteAdapter
import com.example.mynotes.databinding.FragmentNotesHomeBinding
import com.example.mynotes.models.NoteResponse
import com.example.mynotes.utils.NetworkResult
import com.example.mynotes.viewmodels.NotesViewModel



/**
 * A simple [Fragment] subclass.
 * create an instance of this fragment.
 */
class NotesHomeFragment : Fragment() {

    private var _binding: FragmentNotesHomeBinding? = null
    private val binding get() = _binding!!

    private val notesViewModel by activityViewModels<NotesViewModel>()

    private lateinit var adapter: NoteAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentNotesHomeBinding.inflate(inflater, container, false)
        adapter = NoteAdapter(::onNoteClicked)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindObservers()
        notesViewModel.getAllNotes()
        binding.notesList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
        binding.notesList.adapter = adapter
        binding.compassNavigateButton.setOnClickListener{
            findNavController().navigate(R.id.action_notesHomeFragment_to_compassFragment)
        }
        binding.languageButton.setOnClickListener{
            findNavController().navigate(R.id.action_notesHomeFragment_to_languageFragment)
        }
    }

    fun bindObservers(){
        notesViewModel.notesLiveData.observe(viewLifecycleOwner) {
            when (it) {
                is NetworkResult.Success -> {
                        adapter.submitList(it.data)
                }

                is NetworkResult.Error -> {
                        Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()
                }

                is NetworkResult.Loading -> {

                }
            }
        }
    }

    private fun onNoteClicked(noteResponse: NoteResponse){
    }

}