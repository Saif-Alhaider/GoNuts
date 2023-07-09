package com.example.gonuts.screens.welcome

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.gonuts.ui.theme.GoNutsCustomColors
import com.example.gonuts.ui.theme.GoNutsTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun WelcomeContent() {
    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(
        color = GoNutsCustomColors.current.primaryBackground,
    )
    systemUiController.setNavigationBarColor(color = GoNutsCustomColors.current.primaryBackground,)
    Box(
        modifier = Modifier
            .background(color = GoNutsCustomColors.current.primaryBackground)
            .fillMaxSize()
    ) {
        Header()
        WelcomeBody(
            modifier = Modifier
                .fillMaxHeight(.6f)
                .align(Alignment.BottomCenter)
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun WelcomeContentPreview() {
    GoNutsTheme { WelcomeContent() }

}