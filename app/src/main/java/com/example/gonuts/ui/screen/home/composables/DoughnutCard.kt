package com.example.gonuts.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gonuts.R
import com.example.gonuts.ui.theme.GoNutsCustomColors
import com.example.gonuts.ui.theme.GoNutsTheme
import com.example.gonuts.ui.common.state.DoughnutUiState

@Composable
fun DoughnutCard(doughnut: DoughnutUiState) {
    Box(
        contentAlignment = Alignment.CenterEnd, modifier = Modifier
            .height(325.dp)
            .width(200.dp)
    ) {
        //region card content
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .matchParentSize()
                .clip(RoundedCornerShape(20.dp))
                .background(GoNutsCustomColors.current.onPrimary)
                .padding(16.dp)
        ) {
            AddToFavouriteIcon()
            //region card details
            Column {
                //region info
                Text(
                    text = doughnut.name,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = doughnut.description,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.bodySmall
                )
                //endregion

                //region price details
                Row(
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "\$${doughnut.originalPrice}",
                        style = MaterialTheme.typography.labelSmall
                            .copy(textDecoration = TextDecoration.LineThrough),
                        color = GoNutsCustomColors.current.onBackground60
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "\$${doughnut.discountedPrice}",
                        style = MaterialTheme.typography.labelLarge
                    )
                }
                //endregion
            }
            //endregion
        }
        //endregion

        //region doughnut image
        Image(
            painter = painterResource(id = doughnut.imageResource),
            contentDescription = "Doughnut",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxWidth(.8f)
                .fillMaxHeight(.45f)
                .graphicsLayer {
                    translationX = (this.size.width - 130) / 2
                    translationY = -120f
                }
                .scale(1.1f)
        )
        //endregion
    }
}

@Preview
@Composable
fun DoughnutCardPreview() {
    GoNutsTheme {
        DoughnutCard(
            DoughnutUiState(
                name = "Strawberry Wheel",
                description = "These Baked Strawberry Donuts are filled with fresh strawberries...",
                originalPrice = 2.99,
                discountedPrice = 2.49,
                imageResource = R.drawable.doughnut_strawberry_wheel_sprinkles
            )
        )
    }
}