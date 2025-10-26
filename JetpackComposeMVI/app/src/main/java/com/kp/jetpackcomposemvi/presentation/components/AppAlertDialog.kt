package com.kp.jetpackcomposemvi.presentation.components

import androidx.compose.material3.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun AppAlertDialog(
    title: String,
    message: String,
    confirmButtonText: String = "OK",
    dismissButtonText: String? = null,
) {
    AlertDialog(
        title = { Text(title) },
        text = { Text(message) },
        confirmButton = {
            TextButton(onClick = {  }) {
                Text(confirmButtonText)
            }
        },
        dismissButton = {
            dismissButtonText?.let {
                TextButton(onClick = {  }) {
                    Text(it)
                }
            }
        },
        onDismissRequest = {  },
    )
}