package com.example.mynotes.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mynotes.repository.api.NoteAPI
import com.example.mynotes.models.NoteRequest
import com.example.mynotes.models.NoteResponse
import com.example.mynotes.utils.NetworkResult
import org.json.JSONObject
import javax.inject.Inject

class NoteRepository @Inject constructor(private val noteAPI: NoteAPI) {

    private val _notesLiveData = MutableLiveData<NetworkResult<List<NoteResponse>>>()
    val notesLiveData : LiveData<NetworkResult<List<NoteResponse>>>
    get() = _notesLiveData

    private val _statusLiveData = MutableLiveData<NetworkResult<Pair<Boolean, String>>>()
    val statusLiveData : LiveData<NetworkResult<Pair<Boolean, String>>>
    get() = _statusLiveData
    suspend fun createNote(noteRequest: NoteRequest){

    }

    suspend fun getNotes(){
        _notesLiveData.postValue(NetworkResult.Loading())
        val response = noteAPI.getNotes()
        if(response.isSuccessful && response.body() != null){
            _notesLiveData.postValue(NetworkResult.Success(response.body()!!))
        }else if(response.errorBody() != null){
            val error = JSONObject(response.errorBody()!!.charStream().readText())
            _notesLiveData.postValue(NetworkResult.Error(error.getString("message")))
        }else{
            _notesLiveData.postValue(NetworkResult.Error("Something went wrong"))
        }
    }

    suspend fun updateNote(id: String, noteRequest: NoteRequest){

    }

    suspend fun deleteNote(noteId: String){

    }


}