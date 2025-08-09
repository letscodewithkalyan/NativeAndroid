package com.kp.androidarc.presentation.views

import android.app.AlertDialog
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.kp.androidarc.R
import com.kp.androidarc.data.models.NoteModel
import com.kp.androidarc.databinding.FragmentAddNotesBinding
import com.kp.androidarc.databinding.FragmentNotesBinding
import com.kp.androidarc.presentation.viewmodels.AddNotesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddNotesFragment : Fragment() {
    private var _binding: FragmentAddNotesBinding? = null

    private val viewModel: AddNotesViewModel by viewModels()

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAddNotesBinding.inflate(inflater, container,false)
        //return inflater.inflate(R.layout.fragment_add_notes, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val note = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            arguments?.getParcelable("note", NoteModel::class.java)
        } else {
            @Suppress("DEPRECATION")
            arguments?.getParcelable<NoteModel>("note")
        }
        note?.let {
            binding.titleText.editText?.setText(it.title)
            binding.descriptionText.editText?.setText(it.description)
        }
        binding.addNoteButton.setOnClickListener {
            viewModel.addNote(note?.id, binding.titleText.editText?.text.toString(), binding.descriptionText.editText?.text.toString())
            AlertDialog.Builder(requireContext())
                .setTitle("Add Note")
                .setMessage("Notes added successfully")
                .setPositiveButton("Yes") { dialog, _ ->
                    // Handle positive action
                    dialog.dismiss()
                    findNavController().popBackStack()
                }
                .show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}