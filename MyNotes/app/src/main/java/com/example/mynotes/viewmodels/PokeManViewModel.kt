package com.example.mynotes.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynotes.repository.NoteRepository
import com.example.mynotes.repository.PokeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokeManViewModel @Inject constructor(private val pokeRepository: PokeRepository) : ViewModel() {
    val pokeManResult get() = pokeRepository.pokeManData
    // TODO: Implement the ViewModel

    fun getData(){
        viewModelScope.launch {
            pokeRepository.getPokeMan()
        }
    }
}