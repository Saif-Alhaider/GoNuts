package com.example.gonuts.ui.common.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.gonuts.R
import com.example.gonuts.ui.theme.GoNutsCustomColors

@Composable
fun AddToFavouriteIcon(modifier: Modifier = Modifier, shape: Shape = CircleShape) {
    val isActive = remember { mutableStateOf(false) }
    Image(
        painter = painterResource(id = if (isActive.value) R.drawable.ic_heart_filled else R.drawable.heart_add_to_favourite),
        contentDescription = "add to favourite icon",
        modifier = modifier
            .clip(shape)
            .clickable { isActive.value = !isActive.value }
            .background(GoNutsCustomColors.current.background)
            .padding(12.dp)
    )
}