package com.kp.jetpackcomposemvi.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kp.jetpackcomposemvi.presentation.home.HomeView
import com.kp.jetpackcomposemvi.presentation.home.HomeViewModel

@Composable
fun MainNavigation(navHost: NavHostController) {
    NavHost(navHost, "home") {
        composable("home") {
            val viewModel: HomeViewModel = hiltViewModel()
            HomeView(
                viewModel.state,
                { intent -> viewModel.handleIntent(intent) },
                viewModel.effect
            )
        }
    }
}