package com.example.mynotes.viewmodels

import androidx.lifecycle.ViewModel
import com.example.mynotes.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(private val noteRepositoy:NoteRepository) : ViewModel() {
}