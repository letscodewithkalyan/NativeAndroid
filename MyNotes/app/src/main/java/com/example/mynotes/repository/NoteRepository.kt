package com.example.mynotes.repository

import androidx.lifecycle.MutableLiveData
import com.example.mynotes.api.NoteAPI
import com.example.mynotes.models.NoteRequest
import com.example.mynotes.models.NoteResponse
import com.example.mynotes.utils.NetworkResult
import javax.inject.Inject

class NoteRepository @Inject constructor(private val noteAPI: NoteAPI) {

    private val _notesLiveData = MutableLiveData<NetworkResult<List<NoteResponse>>>()
    val notesLiveData get() = _notesLiveData

    private val _statusLiveData = MutableLiveData<NetworkResult<Pair<Boolean, String>>>()
    val statusLiveData get() = _statusLiveData

    suspend fun createNote(noteRequest: NoteRequest){

    }

    suspend fun getNotes(){

    }

    suspend fun updateNote(id: String, noteRequest: NoteRequest){

    }

    suspend fun deleteNote(noteId: String){

    }


}