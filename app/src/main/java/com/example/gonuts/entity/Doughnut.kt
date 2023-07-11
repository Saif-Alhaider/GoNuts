package com.example.gonuts.entity

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

data class Doughnut(
    val name: String,
    val description: String,
    val originalPrice: Double,
    val discountedPrice: Double,
    @DrawableRes val imageResource: Int,
    val backgroundColor: Color
)
