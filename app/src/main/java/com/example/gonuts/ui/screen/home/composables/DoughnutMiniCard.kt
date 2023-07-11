package com.example.gonuts.ui.screen.home.composables

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gonuts.R
import com.example.gonuts.ui.theme.GoNutsCustomColors
import com.example.gonuts.ui.theme.GoNutsTheme

@Composable
fun DoughnutMiniCard(
    modifier: Modifier = Modifier,
    doughnutName: String,
    doughnutPrice: Double,
    @DrawableRes doughnutImageRes: Int,
    onClick: () -> Unit
) {

    Box(
        modifier = modifier
            .size(180.dp)
    ) {
        //region card info
        Surface(
            Modifier
                .padding(top = 60.dp)
                .clip(
                    RoundedCornerShape(
                        topStart = 20.dp,
                        topEnd = 20.dp,
                        bottomStart = 10.dp,
                        bottomEnd = 10.dp
                    )
                )
                .clickable(onClick = onClick)
                .fillMaxHeight()
                .background(color = Color.White)
                .shadow(
                    elevation = 16.dp,
                    shape = RoundedCornerShape(
                        topStart = 20.dp,
                        topEnd = 20.dp,
                        bottomStart = 10.dp,
                        bottomEnd = 10.dp
                    ),
                    spotColor = Color.Black.copy(alpha = .1f)
                )
        ) {
            Column(
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = doughnutName,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.labelSmall,
                    color = GoNutsCustomColors.current.onBackground60,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 50.dp, bottom = 10.dp)
                )
                Text(
                    text = "$$doughnutPrice",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.labelSmall,
                    color = GoNutsCustomColors.current.primary,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 20.dp)
                )
            }
        }
        //endregion
        //region doughnut image
        Image(
            painter = painterResource(id = doughnutImageRes),
            contentDescription = "doughnut image",
            modifier = Modifier
                .align(Alignment.TopCenter)
                .matchParentSize()
                .graphicsLayer {
                    translationY = -120f
                }
                .scale(.9f)
        )
        //endregion
    }
}

@Preview
@Composable
fun DoughnutMiniCardPreview() {
    GoNutsTheme {
        DoughnutMiniCard(
            doughnutName = "Strawberry Flavour",
            doughnutPrice = 4.5,
            doughnutImageRes = R.drawable.doughnut_chocolate_cherry_drizzle,
            onClick = {}
        )
    }
}