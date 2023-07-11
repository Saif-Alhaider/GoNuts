package com.example.gonuts

sealed class Screen(val route: String) {
    object Welcome : Screen(route = "welcome")
    object Home : Screen(route = "home")
    object DoughnutDetails:Screen(route = "doughnut_details")
}