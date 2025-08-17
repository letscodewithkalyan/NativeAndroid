package com.kp.composearc.presentation.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.kp.composearc.data.model.UserModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun ImageScreen() {
    var count by remember { mutableStateOf(1) }

    val derivedStateOfColor by remember(count){
        derivedStateOf {
            if(count % 2 == 0) Color.Green else Color.Yellow
        }
    }
    var user = produceState<UserModel?>(initialValue = null, count, "", "") {
        //we can launch coroutine and fetch the values,
        //
        value = null
    }
    LaunchedEffect("key1") {
        delay(1000)
       println("Launch effect")
    }

    SideEffect {
        println("SideEffect: counter = $count")
    }

    DisposableEffect("key2") {
        onDispose {
            println("DisposableEffect onDispose")
        }
    }

    Column {
        Button({ }) {
            Text("Increment")
        }
        Text("$count", modifier = Modifier
            .background(derivedStateOfColor)
            .padding(10.dp))

    }
}