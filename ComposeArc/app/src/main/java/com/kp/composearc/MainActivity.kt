package com.kp.composearc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.kp.composearc.presentation.navigation.ComposeArcNavigation
import com.kp.composearc.presentation.viewmodels.MainViewModel
import com.kp.composearc.ui.theme.ComposeArcTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeArcTheme(viewModel.theme.value) {
                Surface(modifier = Modifier.fillMaxSize()) {
                    val navController = rememberNavController()
                    ComposeArcNavigation(navController = navController,   onThemeChange = { newMode ->
                        viewModel.setTheme(newMode)
                    })
                }
            }
        }
    }
}