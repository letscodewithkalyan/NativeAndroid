package com.kp.composearc.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kp.composearc.data.datasources.local.dao.NotesDao
import com.kp.composearc.data.datasources.local.entities.NoteEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddNotesViewModel @Inject constructor(private val notesDao: NotesDao) : ViewModel() {
    fun addNotes(id: Int?, title: String, description: String){
        viewModelScope.launch {
            notesDao.insertNote(NoteEntity(id, title, description))
        }
    }
}