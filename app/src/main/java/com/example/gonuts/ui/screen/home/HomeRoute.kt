package com.example.gonuts.ui.screen.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.gonuts.ui.common.composables.BottomNavigation


private const val ROUTE = "home"
fun NavController.navigateToHome() {
    navigate(ROUTE)
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
fun NavGraphBuilder.homeRoute(navController: NavController) {
    composable(ROUTE) {
        Scaffold(bottomBar = { BottomNavigation() }) {
            Box(Modifier.padding(it)) {
                HomeScreen(navController)
            }
        }
    }
}