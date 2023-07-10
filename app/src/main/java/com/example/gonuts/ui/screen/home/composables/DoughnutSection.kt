package com.example.gonuts.ui.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.gonuts.ui.common.state.DoughnutUiState
import com.example.gonuts.ui.theme.GoNutsCustomColors

@Composable
fun DoughnutSection(
    modifier: Modifier = Modifier,
    doughnuts: List<DoughnutUiState>,
    sectionTitle: String,
    spaceByValue: Dp,
    contentPadding: PaddingValues,
    content: @Composable (DoughnutUiState) -> Unit
) {
    Column {
        Text(
            text = sectionTitle,
            style = MaterialTheme.typography.labelMedium,
            color = GoNutsCustomColors.current.onBackground,
            modifier = modifier.padding(top = 32.dp, start = 32.dp)
        )
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(spaceByValue),
            contentPadding = contentPadding,
            modifier = Modifier.padding(top = 25.dp)
        ) {
            items(doughnuts) { singleDoughnut ->
                content(singleDoughnut)
            }
        }
    }
}