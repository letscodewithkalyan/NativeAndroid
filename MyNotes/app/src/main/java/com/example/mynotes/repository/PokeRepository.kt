package com.example.mynotes.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mynotes.models.NoteResponse
import com.example.mynotes.models.PokeManResult
import com.example.mynotes.repository.api.PokeAPI
import com.example.mynotes.utils.NetworkResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class PokeRepository @Inject constructor(private val pokeAPI: PokeAPI) {
    private val _pokeManData = MutableStateFlow<NetworkResult<PokeManResult>>(NetworkResult.Loading());
    val pokeManData : StateFlow<NetworkResult<PokeManResult>>
        get() = _pokeManData
    suspend fun getPokeMan(){

    }
}