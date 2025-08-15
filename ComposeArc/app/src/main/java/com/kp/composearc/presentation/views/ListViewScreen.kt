package com.kp.composearc.presentation.views

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import com.kp.composearc.presentation.viewmodels.ListViewScreenViewModel

@Composable
fun ListViewScreen() {
    val viewModel: ListViewScreenViewModel = viewModel()
    LazyColumn(modifier = Modifier.padding(WindowInsets.safeDrawing.asPaddingValues())) {
        items(viewModel.fruits) { item ->
            Card(
                shape = CardDefaults.elevatedShape,
                modifier = Modifier.padding(10.dp),
                elevation = CardDefaults.cardElevation(4.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Row {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(item.url),
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(40.dp)
                            .clip(RoundedCornerShape(16.dp))
                    )
                    Column(modifier = Modifier
                        .padding(10.dp)
                        .weight(1f)) {
                        Text(item.name)
                        Text(item.description)
                    }
                }

            }

        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ListViewScreenPreview() {
    ListViewScreen()
}