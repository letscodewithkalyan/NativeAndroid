package com.kp.composearc.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kp.composearc.data.model.NoteModel
import com.kp.composearc.presentation.views.AddNotesView
import com.kp.composearc.presentation.views.ComposeComponents
import com.kp.composearc.presentation.views.DBView
import com.kp.composearc.presentation.views.HomeView
import com.kp.composearc.presentation.views.ListViewScreen
import com.kp.composearc.presentation.views.LoginView
import com.kp.composearc.presentation.views.NetworkView
import com.kp.composearc.presentation.views.ScaffoldView

@Composable
fun ComposeArcNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home"){
        composable("home") {
            HomeView(navController)
        }
        composable("network") {
            NetworkView(navController)
        }
        composable("db") {
            DBView(navController)
        }
        composable("scaffold") {
            ScaffoldView(navController)
        }
        composable("addnotes") { backStackEntry ->
            var note = navController.previousBackStackEntry?.savedStateHandle?.get<NoteModel>("note")
            AddNotesView(navController,note)
        }
        composable("login") {
            LoginView(navController)
        }
        composable("composecomponents") {
            ComposeComponents()
        }
        composable("listView") {
            ListViewScreen()
        }
    }
}