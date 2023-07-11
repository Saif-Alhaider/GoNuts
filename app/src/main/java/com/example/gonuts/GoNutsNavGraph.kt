package com.example.gonuts

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.gonuts.ui.screen.doughnut_details.doughnutDetailsRoute
import com.example.gonuts.ui.screen.home.homeRoute
import com.example.gonuts.ui.screen.welcome.welcomeRoute

@Composable
fun GoNutsNavGraph(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = AppDestination.Welcome.route) {
        welcomeRoute(navHostController)
        homeRoute(navHostController)
        doughnutDetailsRoute(navHostController)
    }
}