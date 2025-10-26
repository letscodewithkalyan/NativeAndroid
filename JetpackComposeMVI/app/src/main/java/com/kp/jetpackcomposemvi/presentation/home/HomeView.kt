package com.kp.jetpackcomposemvi.presentation.home

import android.os.Message
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.kp.jetpackcomposemvi.data.model.UserModel
import kotlinx.coroutines.flow.SharedFlow

@Composable
fun HomeView(
    state: HomeViewContract.State,
    intent: (intent: HomeViewContract.Intent) -> Unit,
    effect: SharedFlow<HomeViewContract.Effect>,
) {
    Scaffold() {
        Column(modifier = Modifier.padding(it)) {
            when {
                state.isLoading -> CircularLoader()
                state.errorMessage.isNotEmpty() -> ErrorMessage(state.errorMessage)
                state.users.isNotEmpty() -> UsersList(state,{ intent(HomeViewContract.Intent.OnRefresh)})
            }
        }
    }
}

@Composable
fun CircularLoader() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }
}

@Composable
fun ErrorMessage(message: String) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(message)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UsersList(state: HomeViewContract.State, onRefresh: () -> Unit) {
    PullToRefreshBox(
        isRefreshing = state.isRefreshing,
        onRefresh = { onRefresh()}
    ) {
        LazyColumn {
            items(state.users) {
                UserCard(it)
            }
        }
    }
}

@Composable
fun UserCard(userModel: UserModel){
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(6.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(10.dp)) {
            Text(userModel.username)
            Text(userModel.email)
            Text(userModel.phone)
        }
    }
}