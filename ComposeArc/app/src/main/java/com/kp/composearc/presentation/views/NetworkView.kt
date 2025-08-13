package com.kp.composearc.presentation.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.kp.composearc.presentation.viewmodels.NetworkViewModel
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import com.kp.composearc.data.datasources.network.NetworkResult
import com.kp.composearc.data.model.UserModel
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.kp.composearc.presentation.components.UserAvater

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NetworkView(navController: NavController) {
    val viewModel: NetworkViewModel = hiltViewModel()
    val userState by viewModel.userData.collectAsState()

    Scaffold(
        topBar = { TopAppBar(title = { Text("Network") }) }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {
            when (userState) {
                is NetworkResult.Loading -> {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
                }

                is NetworkResult.Error -> {
                    Text((userState as NetworkResult.Error).message)
                }

                is NetworkResult.Success -> {
                    val users = (userState as NetworkResult.Success<List<UserModel>>).data
                    LazyColumn {
                        items(users) { user ->
                            Card(
                                modifier = Modifier
                                    .padding(10.dp)
                                    .fillMaxSize(),
                                shape = RoundedCornerShape(12.dp),
                                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                                colors = CardDefaults.cardColors(containerColor = Color.White)
                            ) {
                                Row(modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(10.dp)) {
                                    UserAvater(user)
                                    Column(modifier = Modifier.padding(12.dp, 0.dp)) {
                                        Text("${user.firstname} ${user.lastname}")
                                        Text(user.email)
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun NetworkViewPreview() {
    val nav = rememberNavController()
    NetworkView(nav)
}