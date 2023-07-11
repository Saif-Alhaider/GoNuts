package com.example.gonuts.ui.common.state

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import com.example.gonuts.R

data class DoughnutUiState(
    val name: String = "",
    val description: String = "",
    val originalPrice: Double = 0.0,
    val discountedPrice: Double = 0.0,
    @DrawableRes val imageResource: Int = R.drawable.doughnut_strawberry_wheel_sprinkles,
    val backgroundColor: Color = Color.Gray
)