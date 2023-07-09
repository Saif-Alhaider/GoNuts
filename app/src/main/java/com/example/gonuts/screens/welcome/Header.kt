package com.example.gonuts.screens.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gonuts.R

@Composable
fun Header(modifier: Modifier=Modifier) {
    Box(
        modifier
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.doughnut_group),
            contentDescription = "group of doughnut",
            modifier = Modifier
                .matchParentSize()
                .scale(1.6f,1.5f)
                .rotate(16.18f)
                .offset(y = 20.dp, x = 20.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.doughnut_strawberry_sprinkles_eaten),
            contentDescription = "doughnut strawberry sprinkles eaten",
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .offset(x = 90.dp, y = 160.dp)
                .scale(.9f)
        )
        Image(
            painter = painterResource(id = R.drawable.doughnut_strawberry_sprinkles_drizzle),
            contentDescription = "doughnut strawberry sprinkles drizzle",
            modifier = Modifier
                .align(Alignment.TopEnd)
                .offset(x = (-40).dp, y = (-15).dp)
                .scale(.85f)
        )

        Image(
            painter = painterResource(id = R.drawable.doughnut_strawberry_sprinkles_drizzle),
            contentDescription = "doughnut strawberry sprinkles drizzle",
            modifier = Modifier
                .scale(.4f)
                .rotate(65f)
                .align(Alignment.BottomStart)
                .offset(y = 40.dp, x = 30.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.doughnut_purple_sprinkles),
            contentDescription = "doughnut purple sprinkles",
            modifier = Modifier
                .align(Alignment.TopStart)
                .scale(.85f)
                .offset(x = (-25).dp, y = (-50).dp)
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun HeaderPreview() {
    Header()
}