package com.example.gonuts.ui.screen.home

import androidx.lifecycle.ViewModel
import com.example.gonuts.ui.common.state.mapToUi
import com.example.gonuts.usecase.GetDoughnutsUseCase
import com.example.gonuts.usecase.GetTodayOffersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getTodayOffersUseCase: GetTodayOffersUseCase,
    private val getDoughnutsUseCase: GetDoughnutsUseCase,
) : ViewModel() {
    private val _state = MutableStateFlow(HomeUiState())
    val state = _state.asStateFlow()

    init {
        getTodayOffers()
        getDoughnuts()
    }

    private fun getTodayOffers() {
        val todayOffers = getTodayOffersUseCase().map { it.mapToUi() }
        _state.update { it.copy(todayOffers = todayOffers) }
    }

    private fun getDoughnuts() {
        val doughnuts = getDoughnutsUseCase().map { it.mapToUi() }
        _state.update { it.copy(doughnuts = doughnuts) }
    }
}