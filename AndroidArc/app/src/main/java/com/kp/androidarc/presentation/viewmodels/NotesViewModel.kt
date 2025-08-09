package com.kp.androidarc.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kp.androidarc.data.datasources.local.dao.NotesDao
import com.kp.androidarc.data.datasources.local.entities.Note
import com.kp.androidarc.data.models.NoteModel
import com.kp.androidarc.data.models.toModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(val notesDao: NotesDao) : ViewModel() {
    private val _notes:MutableStateFlow<List<NoteModel>> = MutableStateFlow<List<NoteModel>>(emptyList())
    val notes: StateFlow<List<NoteModel>> = _notes

    init {
        viewModelScope.launch {
            notesDao.getAllNotes()
                .map { noteList -> noteList.map { it.toModel() } }
                .collect { notesModel ->
                _notes.value = notesModel
            }
        }
    }
}