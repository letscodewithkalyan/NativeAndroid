package com.example.mynotes.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mynotes.models.NoteResponse
import com.example.mynotes.models.PokeManResult
import com.example.mynotes.repository.api.PokeAPI
import com.example.mynotes.utils.Constants
import com.example.mynotes.utils.NetworkResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.json.JSONObject
import javax.inject.Inject

class PokeRepository @Inject constructor(private val pokeAPI: PokeAPI) {
    private val _pokeManData = MutableStateFlow<NetworkResult<PokeManResult>>(NetworkResult.Loading());
    val pokeManData : StateFlow<NetworkResult<PokeManResult>>
        get() = _pokeManData
    suspend fun getPokeMan()
    {
        val response = pokeAPI.getPokeResult(Constants.POKE_URL)
        if(response.isSuccessful && response.body() != null){
            _pokeManData.value = NetworkResult.Success(response.body()!!)
        }else if(response.errorBody() != null) {
            val error = JSONObject(response.errorBody()!!.charStream().readText())
            _pokeManData.value = NetworkResult.Error(error.getString("message"))
        }else{
            _pokeManData.value = NetworkResult.Error("Something went wrong")
        }
    }
}