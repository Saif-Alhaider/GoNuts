package com.example.gonuts

sealed class AppDestination(val route: String) {
    object Welcome : AppDestination(route = "welcome")
    object Home : AppDestination(route = "home")
    object DoughnutDetails:AppDestination(route = "doughnut_details")
}