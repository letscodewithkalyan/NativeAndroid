package com.kp.composearc.presentation.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage

import com.kp.composearc.presentation.viewmodels.ListViewScreenViewModel

@Composable
fun ListViewScreen(navController: NavController) {
    val viewModel: ListViewScreenViewModel = viewModel()

    LazyColumn(modifier = Modifier.padding(WindowInsets.safeDrawing.asPaddingValues())) {
        items(viewModel.fruits) { item ->
            Card(
                shape = CardDefaults.elevatedShape,
                modifier = Modifier.padding(10.dp),
                elevation = CardDefaults.cardElevation(4.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                onClick = {
                    navController.currentBackStackEntry?.savedStateHandle?.set("fruit", item);
                    navController.navigate("fruitDetails")
                }
            ) {
                Row {
                    AsyncImage(
                        model = item.imageUrl,
                        contentDescription = null,
                        modifier = Modifier
                            .size(80.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .align(alignment = Alignment.CenterVertically)
                    )
                    Column(
                        modifier = Modifier
                            .padding(10.dp)
                            .weight(1f),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(item.name, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                        Text(item.description, fontSize = 14.sp)
                    }
                }

            }
        }
        item {
            Text("Footer")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ListViewScreenPreview() {
    var navController = rememberNavController()
    ListViewScreen(navController)
}