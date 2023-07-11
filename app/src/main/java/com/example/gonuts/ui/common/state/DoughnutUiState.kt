package com.example.gonuts.ui.common.state

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import com.example.gonuts.R
import com.example.gonuts.entity.Doughnut

data class DoughnutUiState(
    val name: String = "",
    val description: String = "",
    val originalPrice: Double = 0.0,
    val discountedPrice: Double = 0.0,
    @DrawableRes val frontViewImageResource: Int = R.drawable.doughnut_strawberry_wheel_sprinkles,
    @DrawableRes val tiltedViewImageResource: Int = R.drawable.doughnut_chocolate_cherry_drizzle,
    val backgroundColor: Color = Color.Gray
)

fun Doughnut.mapToUi(): DoughnutUiState {
    return DoughnutUiState(
        name = this.name,
        description = this.description,
        originalPrice = this.originalPrice,
        discountedPrice = this.discountedPrice,
        frontViewImageResource = this.frontViewImageResource,
        backgroundColor = this.backgroundColor,
        tiltedViewImageResource = this.tiltedViewImageResource
    )
}