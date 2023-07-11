package com.example.gonuts.ui.screen.doughnut_details

import com.example.gonuts.ui.common.state.DoughnutUiState

data class DoughnutDetailsUiState(
    val amount: Int = 0,
    val doughnut: DoughnutUiState = DoughnutUiState()
)