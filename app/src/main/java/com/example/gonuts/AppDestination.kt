package com.example.gonuts

import androidx.annotation.DrawableRes

sealed class AppDestination(val route: String, @DrawableRes val icon: Int? = null) {
    object Welcome : AppDestination("welcome")
    object Home : AppDestination("home",icon = R.drawable.ic_home)
    object DoughnutDetails : AppDestination("doughnut_details")
    object Favourite : AppDestination("favourite",R.drawable.ic_heart_bottom_navigation)
    object Notification : AppDestination("notification",R.drawable.ic_notification)
    object Cart : AppDestination("cart",R.drawable.ic_cart)
    object Profile : AppDestination("profile",R.drawable.ic_profile)
}