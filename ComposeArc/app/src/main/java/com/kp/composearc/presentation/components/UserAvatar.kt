package com.kp.composearc.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.kp.composearc.data.model.UserModel

@Composable
fun UserAvater(user: UserModel) {
    val initials =
        "${user.firstname.firstOrNull() ?: ""}${user.lastname.firstOrNull() ?: ""}".uppercase()

    Box(
        modifier = Modifier
            .size(52.dp)
            .clip(CircleShape)
            .background(Color.Blue),
        contentAlignment = Alignment.Center
    ) {
        Text(initials, fontWeight = FontWeight.Bold, color = Color.White)
    }
}