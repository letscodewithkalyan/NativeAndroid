package com.kp.jetpackcomposemvi.presentation.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kp.jetpackcomposemvi.core.NetworkResult
import com.kp.jetpackcomposemvi.data.model.UserModel
import com.kp.jetpackcomposemvi.data.repository.DataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val dataRepository: DataRepository) : ViewModel() {
    var state by mutableStateOf(HomeViewContract.State())
        private set
    var effect = MutableSharedFlow<HomeViewContract.Effect>()
        private set

    init {
        loadUsers()
    }

    fun handleIntent(intent: HomeViewContract.Intent) {
        when (intent) {
            is HomeViewContract.Intent.OnListItemClick -> TODO()
            HomeViewContract.Intent.OnRefresh -> {
                state = state.copy(isRefreshing = true)
                loadUsers()
            }
        }
    }

    fun loadUsers() {
        viewModelScope.launch {
            var users = dataRepository.getUsers()
            state = when (users) {
                is NetworkResult.Error -> {
                    state.copy(isLoading = false, isRefreshing = false, errorMessage = users.errorMesage)
                }

                is NetworkResult.Success<*> -> {
                    state.copy(isLoading = false, isRefreshing = false, users = users.data as List<UserModel>)
                }
            }
        }
    }
}