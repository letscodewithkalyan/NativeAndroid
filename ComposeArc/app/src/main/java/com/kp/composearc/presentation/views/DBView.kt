package com.kp.composearc.presentation.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.kp.composearc.presentation.viewmodels.DBViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import androidx.room.util.TableInfo
import com.kp.composearc.data.model.NoteModel

@Composable
fun DBView(navController: NavController) {
    var viewModel: DBViewModel = hiltViewModel()
    val notes by viewModel.notes.collectAsState()

    Scaffold { padding ->
        Column(modifier = Modifier
            .padding(padding)) {
            LazyColumn(modifier = Modifier.weight(1f)) {
                items(notes) { note ->
                    Card(
                        modifier = Modifier
                            .padding(10.dp)
                            .clickable{
                                navController.currentBackStackEntry?.savedStateHandle?.set("note",note)
                                navController.navigate("addnotes")
                            },
                        shape = RoundedCornerShape(12.dp),
                        elevation = CardDefaults.cardElevation(10.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.White)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(6.dp)
                        ) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text(note.title)
                                Text(note.description)
                            }
                            Icon(
                                Icons.AutoMirrored.Filled.KeyboardArrowRight,
                                contentDescription = "arrow",
                                modifier = Modifier.align(Alignment.CenterVertically)
                            )
                        }
                    }
                }
            }
            Button(
                onClick = { navController.navigate("addnotes") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                Text("Add Note")
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun DBViewPreView() {
    val navController = rememberNavController()
    DBView(navController)
}
