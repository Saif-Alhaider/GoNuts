package com.example.gonuts.screens.welcome

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gonuts.components.ButtonPrimary
import com.example.gonuts.ui.theme.GoNutsCustomColors
import com.example.gonuts.ui.theme.GoNutsTheme

@Composable
fun WelcomeBody(modifier: Modifier = Modifier) {
    Column(
        modifier
            .padding(horizontal = 40.dp)

    ) {
        WelcomeTitle(text = "Gonuts\nwith\nDonuts")
        WelcomeSubtitle(
            text = "Gonuts with Donuts is a Sri Lanka dedicated food outlets for specialize manufacturing of Donuts in Colombo, Sri Lanka.",
            modifier = Modifier.padding(top = 19.dp)
        )
        Box(Modifier.weight(1f)) {
            ButtonPrimary(
                text = "Get Started",
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 40.dp)
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun WelcomeBodyPreview() {
    GoNutsTheme {
        Box(modifier = Modifier.background(color = GoNutsCustomColors.current.primaryBackground)) {
            WelcomeBody()
        }
    }
}