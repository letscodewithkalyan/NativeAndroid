package com.kp.androidarc.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kp.androidarc.data.datasources.local.dao.NotesDao
import com.kp.androidarc.data.datasources.local.dao.UserDao
import com.kp.androidarc.data.datasources.local.entities.Note
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddNotesViewModel @Inject constructor(val notesDao: NotesDao) : ViewModel(){

    fun addNote(id: Int? , currentTitle: String, currentDescription: String){
        viewModelScope.launch {
            var note = Note(id,title = currentTitle, description = currentDescription);
            notesDao.insertNote(note);
        }
    }
}