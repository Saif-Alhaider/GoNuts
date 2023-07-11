package com.example.gonuts.ui.common.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gonuts.AppDestination
import com.example.gonuts.R
import com.example.gonuts.ui.theme.GoNutsCustomColors

@Composable
fun BottomNavigation() {
    val item = listOf<AppDestination>(
        AppDestination.Home,
        AppDestination.Favourite,
        AppDestination.Notification,
        AppDestination.Cart,
        AppDestination.Profile
    )

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .height(74.dp)
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .background(color = GoNutsCustomColors.current.background)
    ) {
        item.forEach {
            Image(
                painter = painterResource(id = it.icon ?: R.drawable.ic_home),
                contentDescription = "icon"
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun BottomNavigationPreview() {
    BottomNavigation()
}