package com.kp.composearc.presentation.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldView(navController: NavController) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()

    ModalNavigationDrawer(
        drawerState = drawerState, drawerContent = {
            ModalDrawerSheet {
                Text("Menu")
                NavigationDrawerItem(label = { Text("Home") }, selected = false, onClick = {})
                NavigationDrawerItem(label = { Text("Profile") }, selected = false, onClick = {})
            }
        }) {
        Scaffold(
            topBar = {
                TopAppBar(title = {Text("ScaffoldView")}, navigationIcon = {
                    IconButton(onClick = {scope.launch { drawerState.open() }}) {
                        Icon(Icons.Default.Menu, contentDescription = "menu")
                    }
                })
            },
            bottomBar = {
                NavigationBar {
                    val items = listOf("Home", "Profile", "Settings")
                    items.forEach { item ->
                        NavigationBarItem(
                            selected = false,
                            onClick = {},
                            label = {Text(item)},
                            icon = {Icon(Icons.Default.Home, contentDescription = item)}
                        )

                    }
                }
            }

        ) { padding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)

            ) {
                Text("Main Content Area")
            }
        }
    }
}