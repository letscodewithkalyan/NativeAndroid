package com.example.mynotes.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynotes.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(private val noteRepositoy:NoteRepository) : ViewModel() {

    val notesLiveData get() = noteRepositoy.notesLiveData

    fun getAllNotes(){
        viewModelScope.launch {
            noteRepositoy.getNotes()
        }
    }
}