package com.kp.composearc.presentation.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeView(navController: NavController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = { navController.navigate("network") }) {
            Text("Network")
        }
        Button(onClick = { navController.navigate("db") }) {
            Text("db")
        }
        Button(onClick = {navController.navigate("scaffold")}) {
            Text("Scaffold")
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun HomeViewPreview() {
    val nav = rememberNavController()
    HomeView(nav)
}