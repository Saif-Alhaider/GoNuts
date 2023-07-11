package com.example.gonuts.ui.screen.doughnut_details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.gonuts.ui.common.state.mapToUi
import com.example.gonuts.ui.screen.home.AmountSelectorListener
import com.example.gonuts.usecase.GetDoughnutByNameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class DoughnutDetailsViewModel @Inject constructor(
    private val getDoughnutByNameUseCase: GetDoughnutByNameUseCase,
    savedStateHandle: SavedStateHandle
) :
    ViewModel(), AmountSelectorListener {
    private val _state = MutableStateFlow(DoughnutDetailsUiState())
    val state = _state.asStateFlow()

    private val args: DoughnutDetailsArgs = DoughnutDetailsArgs(savedStateHandle)

    init {
        getDoughnut()
    }

    private fun getDoughnut() {
        val doughnut = getDoughnutByNameUseCase().first { it.name == args.name }
        _state.update { it.copy(doughnut = doughnut.mapToUi()) }
    }

    override fun onClickIncrement() {
        _state.update { it.copy(amount = it.amount + 1) }
    }

    override fun onClickDecrement() {
        _state.update { it.copy(amount = if (it.amount == 0) 0 else it.amount - 1) }
    }
}