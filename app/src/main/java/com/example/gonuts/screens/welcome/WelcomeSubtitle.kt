package com.example.gonuts.screens.welcome

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.gonuts.ui.theme.GoNutsCustomColors
import com.example.gonuts.ui.theme.GoNutsTheme

@Composable
fun WelcomeSubtitle(modifier: Modifier = Modifier, text: String) {
    Text(
        text = text,
        color = GoNutsCustomColors.current.subtitle,
        style = MaterialTheme.typography.bodyLarge
    )
}

@Preview()
@Composable
fun WelcomeSubtitlePreview() {
    GoNutsTheme {
        WelcomeSubtitle(text = "Gonuts with Donuts is a Sri Lanka dedicated food outlets for specialize manufacturing of Donuts in Colombo, Sri Lanka.")
    }
}