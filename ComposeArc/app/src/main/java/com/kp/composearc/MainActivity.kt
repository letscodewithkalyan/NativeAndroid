package com.kp.composearc

import android.content.Context
import android.content.Intent
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
import com.squareup.leakcanary.core.BuildConfig
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        if (BuildConfig.DEBUG) {
            System.setProperty("kotlinx.coroutines.debug", "on")
        }
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