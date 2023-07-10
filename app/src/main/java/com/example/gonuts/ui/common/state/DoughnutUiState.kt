package com.example.gonuts.ui.common.state

import androidx.annotation.DrawableRes

data class DoughnutUiState(
    val name: String = "",
    val description: String = "",
    val originalPrice: Double = 0.0,
    val discountedPrice: Double = 0.0,
    @DrawableRes val imageResource: Int
)