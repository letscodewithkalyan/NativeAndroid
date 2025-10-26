package com.kp.composearc.presentation.viewmodels

import android.health.connect.datatypes.units.Length
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kp.composearc.data.datasources.local.dao.NotesDao
import com.kp.composearc.data.mapper.toModel
import com.kp.composearc.data.model.NoteModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DBViewModel @Inject constructor(private val notesDao: NotesDao) : ViewModel() {
    private val _notes: MutableStateFlow<List<NoteModel>> =
        MutableStateFlow<List<NoteModel>>(emptyList())
    val notes: StateFlow<List<NoteModel>> = _notes

    init {
        viewModelScope.launch {
            notesDao.getAllNotes()
                .map { noteList -> noteList.map { it.toModel() } }
                .collect { notes ->
                    _notes.value = notes
                }

        }


    }
}