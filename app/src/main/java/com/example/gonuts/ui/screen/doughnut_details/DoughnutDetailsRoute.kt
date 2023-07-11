package com.example.gonuts.ui.screen.doughnut_details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.ui.Modifier
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

private const val ROUTE = "doughnut_details"

fun NavController.navigateToDoughnutDetails(name:String) {
    navigate("$ROUTE/${name}")
}

fun NavGraphBuilder.doughnutDetailsRoute(navController: NavController) {
    composable(
        "$ROUTE/{${DoughnutDetailsArgs.NAME_ARG}}",
        arguments = listOf(navArgument("name") { NavType.StringType })
    ) {
        Box(Modifier.systemBarsPadding()){DoughnutDetailsScreen(
            navController
        )}
    }
}

class DoughnutDetailsArgs(savedStateHandle: SavedStateHandle) {
    val name: String = checkNotNull(savedStateHandle[NAME_ARG])

    companion object {
        const val NAME_ARG = "name"
    }
}