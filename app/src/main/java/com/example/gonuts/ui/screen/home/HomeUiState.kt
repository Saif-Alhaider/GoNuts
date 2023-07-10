package com.example.gonuts.ui.screen.home

import com.example.gonuts.entity.Doughnut
import com.example.gonuts.ui.viewmodel.common.state.DoughnutUiState

data class HomeUiState(
    val todayOffers: List<DoughnutUiState> = emptyList(),
    val doughnuts: List<DoughnutUiState> = emptyList()
)

fun Doughnut.mapToUi(): DoughnutUiState {
    return DoughnutUiState(
        name = this.name,
        description = this.description,
        originalPrice = this.originalPrice,
        discountedPrice = this.discountedPrice,
        imageResource = this.imageResource
    )
}