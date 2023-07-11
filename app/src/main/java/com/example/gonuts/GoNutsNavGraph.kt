package com.example.gonuts

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.gonuts.ui.screen.home.homeRoute
import com.example.gonuts.ui.screen.welcome.WelcomeContent
import com.example.gonuts.ui.screen.welcome.WelcomeScreen
import com.example.gonuts.ui.screen.welcome.welcomeRoute

@Composable
fun GoNutsNavGraph(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = Screen.Welcome.route) {
        welcomeRoute(navHostController)
        homeRoute(navHostController)
    }
}