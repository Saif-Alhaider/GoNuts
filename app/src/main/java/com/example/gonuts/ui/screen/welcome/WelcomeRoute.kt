package com.example.gonuts.ui.screen.welcome

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

private const val ROUTE = "welcome"

fun NavGraphBuilder.welcomeRoute(navController: NavController) {
    composable(ROUTE) { WelcomeScreen(navController) }
}