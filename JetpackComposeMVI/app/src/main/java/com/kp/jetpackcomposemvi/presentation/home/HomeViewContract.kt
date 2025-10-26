package com.kp.jetpackcomposemvi.presentation.home

import com.kp.jetpackcomposemvi.data.model.UserModel


sealed class HomeViewContract {
    data class State(
        val isLoading: Boolean = false,
        val isRefreshing: Boolean = false,
        val users: List<UserModel> = emptyList(),
        val errorMessage: String = "",
    )

    sealed class Intent{
        object OnRefresh : Intent()
        data class OnListItemClick(val userModel: UserModel): Intent()
    }

    sealed class Effect{
        data class ShowSnackbar(val message: String): Effect()
        data class ShowDialog(val message: String): Effect()
    }
}