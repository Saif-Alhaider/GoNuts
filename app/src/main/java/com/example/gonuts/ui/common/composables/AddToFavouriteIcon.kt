package com.example.gonuts.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.gonuts.R
import com.example.gonuts.ui.theme.GoNutsCustomColors

@Composable
fun AddToFavouriteIcon(shape: Shape = CircleShape) {
    Image(
        painter = painterResource(id = R.drawable.heart_add_to_favourite),
        contentDescription = "add to favourite icon",
        modifier = Modifier
            .clip(shape)
            .clickable { }
            .background(GoNutsCustomColors.current.background)
            .padding(8.dp)
    )
}