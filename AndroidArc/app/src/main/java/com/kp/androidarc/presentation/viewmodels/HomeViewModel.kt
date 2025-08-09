package com.kp.androidarc.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kp.androidarc.data.datasources.network.NetworkResult
import com.kp.androidarc.data.models.UserDataModel
import com.kp.androidarc.data.repository.FakerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(val respository: FakerRepository) : ViewModel() {

    private val _userData = MutableStateFlow<NetworkResult<List<UserDataModel>>>(NetworkResult.Loading)
    val userData: StateFlow<NetworkResult<List<UserDataModel>>> = _userData

    init {
        loaduserData()
    }

    fun loaduserData() {
        viewModelScope.launch {
            _userData.value = NetworkResult.Loading
            _userData.value = respository.getUsers()
        }
    }
}