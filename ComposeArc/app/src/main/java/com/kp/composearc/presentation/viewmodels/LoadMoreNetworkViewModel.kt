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
class LoadMoreNetworkViewModel @Inject constructor(private val fakerRepository: FakerRepository) : ViewModel() {
    private var _userData = MutableStateFlow<NetworkResult<List<UserModel>>>(NetworkResult.Loading)
    val userData: StateFlow<NetworkResult<List<UserModel>>> = _userData
    var loadeMore = MutableStateFlow(false)
    var currentPage = 1
    private val loadedUsers = mutableListOf<UserModel>()

    fun loadUsers() {
        viewModelScope.launch {
            currentPage = 1
            var usersData = fakerRepository.getUsers(currentPage)
            if(usersData is NetworkResult.Success){
                loadedUsers.addAll(usersData.data)
                _userData.value = NetworkResult.Success(loadedUsers.toList());
            }
            currentPage++
        }
    }

    fun loadMoreUsers() {
        if (!loadeMore.value) {
            loadeMore.value = true
            viewModelScope.launch {
                var userData = fakerRepository.getUsers(currentPage)
                if(userData is NetworkResult.Success){
                    loadedUsers.addAll(userData.data)
                    _userData.value = NetworkResult.Success(loadedUsers.toList());
                    currentPage++
                    loadeMore.value = false
                }
            }
        }
    }
}