package com.kp.composearc.presentation.views

import android.R.attr.maxWidth
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.kp.composearc.core.toColor
import com.kp.composearc.data.model.FruitModel
import java.time.format.TextStyle

@Composable
fun FruitDetailsView(fruit: FruitModel) {
    Column {
        Box(
            modifier = Modifier
                .weight(0.4f)
                .fillMaxWidth()
        ) {
            val parentSize = maxWidth // same as maxHeight since aspect ratio is 1

            // Inner Red Circle
            Box(
                modifier = Modifier
                    .fillMaxSize(1f)
                    .aspectRatio(1f)
                    .offset(x = (-10).dp, y = (-10).dp)
                    .clip(CircleShape)
                    .background(fruit.color.toColor().copy(alpha = 0.3f)) // Orange 60% visible
            )
            Box(
                modifier = Modifier
                    .fillMaxSize(1f) // 150% of parent's size
                    .aspectRatio(1f)
                    .offset(x = (-60).dp, y = (-60).dp)
                    .clip(CircleShape)
                    .background(fruit.color.toColor().copy(alpha = 0.6f))
            )

            Box(
                modifier = Modifier
                    .fillMaxSize(0.8f) // 150% of parent's size
                    .aspectRatio(1f)
                    .offset(x = (-40).dp, y = (-40).dp)
                    .clip(CircleShape)
                    .background(fruit.color.toColor())
            )

            AsyncImage(
                model = fruit.imageUrl,
                contentDescription = "",
                modifier = Modifier
                    .fillMaxSize(0.6f)
                    .align(Alignment.Center)
            )

        }
        Surface(
            modifier = Modifier
                .weight(0.6f)
                .fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            shadowElevation = 8.dp
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(fruit.name, fontSize = 16.sp)
                Text(fruit.description, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Spacer(modifier = Modifier.weight(1f)) // pushes the button to the bottom
                Button({}, colors = ButtonDefaults.buttonColors(containerColor = fruit.color.toColor())) {
                    Text("Proceed")
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun FruitPreview() {
    FruitDetailsView(FruitModel("", "", "Test", "Test"))
}