package com.example.gonuts.screens.welcome

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.gonuts.ui.theme.GoNutsCustomColors
import com.example.gonuts.ui.theme.GoNutsTheme

@Composable
fun WelcomeTitle(modifier: Modifier = Modifier, text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.displayLarge,
        color = GoNutsCustomColors.current.primary,
        modifier = modifier
    )
}

@Preview
@Composable
fun WelcomeTitlePreview() {
    GoNutsTheme { WelcomeTitle(text = "Gonuts\nwith\nDonuts") }
}