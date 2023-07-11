package com.example.gonuts.ui.screen.home

import com.example.gonuts.entity.Doughnut
import com.example.gonuts.ui.common.state.DoughnutUiState

data class HomeUiState(
    val todayOffers: List<DoughnutUiState> = emptyList(),
    val doughnuts: List<DoughnutUiState> = emptyList()
)