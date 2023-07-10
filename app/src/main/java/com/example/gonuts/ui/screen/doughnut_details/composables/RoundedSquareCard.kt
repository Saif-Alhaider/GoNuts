package com.example.gonuts.ui.screen.doughnut_details.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
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

@Composable
fun RoundedSquareCard(
    onClick: (() -> Unit)? = null,
    text: String,
    textColor: Color = Color.Black,
    color: Color,
) {
    Surface(
        Modifier.shadow(
            elevation = 4.dp,
            shape = RoundedCornerShape(32),
            spotColor = Color.Black.copy(alpha = .1f)
        )
    ) {
        Box(
            Modifier
                .size(45.dp)
                .clip(RoundedCornerShape(32))
                .clickable(enabled = onClick != null, onClick = onClick ?: {})
                .background(color),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                style = MaterialTheme.typography.labelLarge,
                color = textColor,
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Preview
@Composable
fun RoundedSquareCardPreview() {
    RoundedSquareCard(color = Color.White, text = "-")
}