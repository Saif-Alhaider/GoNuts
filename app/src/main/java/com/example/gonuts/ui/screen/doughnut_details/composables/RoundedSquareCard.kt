package com.example.gonuts.ui.screen.doughnut_details.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RoundedSquareCard(
    onClick: () -> Unit = {},
    color: Color,
    content: @Composable () -> Unit
) {
    Box(
        Modifier
            .size(45.dp)
            .clip(RoundedCornerShape(32))
            .clickable(onClick = onClick)
            .background(color)
            .shadow(
                elevation = 4.dp,
                shape = RoundedCornerShape(32),
                spotColor = Color.Black.copy(alpha = .1f)
            ),
        contentAlignment = Alignment.Center
    ) {
        content()
    }
}

@Preview
@Composable
fun RoundedSquareCardPreview() {
    RoundedSquareCard(color = Color.White) {
        Text(
            text = "-",
            style = MaterialTheme.typography.titleLarge.copy(fontSize = 32.sp),
            color = Color.Black,
            lineHeight = 0.5.sp
        )
    }
}