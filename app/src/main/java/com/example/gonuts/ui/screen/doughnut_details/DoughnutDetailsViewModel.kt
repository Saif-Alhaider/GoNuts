package com.example.gonuts.ui.screen.doughnut_details

import androidx.lifecycle.ViewModel
import com.example.gonuts.ui.common.state.DoughnutUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class DoughnutDetailsViewModel @Inject constructor(): ViewModel() {
    private val _state = MutableStateFlow(DoughnutUiState())
    val state = _state.asStateFlow()
}