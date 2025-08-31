package com.kp.composearc.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kp.composearc.data.datasources.network.NetworkResult
import com.kp.composearc.data.model.UserModel
import com.kp.composearc.data.repository.FakerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NetworkViewModel @Inject constructor(fakerRepository: FakerRepository) : ViewModel() {

    private val _userData = MutableStateFlow<NetworkResult<List<UserModel>>>(NetworkResult.Loading)
    val userData: StateFlow<NetworkResult<List<UserModel>>> = _userData
    init {
        viewModelScope.launch {
            _userData.value = fakerRepository.getUsers(1)
        }
    }
}