package com.example.gonuts.ui.screen.doughnut_details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.unit.sp
import com.example.gonuts.R
import com.example.gonuts.ui.common.composables.AddToFavouriteIcon
import com.example.gonuts.ui.screen.doughnut_details.composables.RoundedSquareCard
import com.example.gonuts.ui.theme.GoNutsCustomColors
import com.example.gonuts.ui.theme.GoNutsTheme

@Composable
fun DoughnutDetailsContent() {
    Box(modifier = Modifier.fillMaxSize()) {

        //region upper
        Column(
            Modifier
                .background(GoNutsCustomColors.current.onPrimaryContainer)
                .fillMaxWidth()
                .fillMaxHeight(.5f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.doughnut_strawberry_wheel_sprinkles),
                contentDescription = "dougnut image",
                modifier = Modifier
                    .scale(5f)
            )
        }
        //endregion

        //region body
        Box(
            Modifier

                .fillMaxWidth()
                .fillMaxHeight(.68f)
                .align(Alignment.BottomCenter)
        ) {
            Column(
                Modifier
                    .clip(RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp))
                    .fillMaxWidth()
                    .fillMaxHeight(.88f)
                    .background(GoNutsCustomColors.current.background)
                    .align(Alignment.BottomCenter)
                    .padding(top = 35.dp, start = 40.dp, end = 40.dp)
            ) {
                Text(
                    text = "Strawberry Wheel",
                    style = MaterialTheme.typography.titleLarge,
                    color = GoNutsCustomColors.current.primary
                )
                Text(
                    text = "About Gonut",
                    style = MaterialTheme.typography.bodyLarge,
                    color = GoNutsCustomColors.current.onBackground.copy(alpha = .8f),
                    modifier = Modifier.padding(top = 32.dp)
                )
                Text(
                    text = "These soft, cake-like Strawberry Frosted Donuts feature fresh strawberries and a delicious fresh strawberry glaze frosting. Pretty enough for company and the perfect treat to satisfy your sweet tooth.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = GoNutsCustomColors.current.onBackground60,
                    modifier = Modifier.padding(top = 16.dp)
                )
                Text(
                    text = "Quantity",
                    style = MaterialTheme.typography.bodyLarge,
                    color = GoNutsCustomColors.current.onBackground,
                    modifier = Modifier.padding(top = 16.dp)
                )
                //region quantity
                Row(
                    horizontalArrangement = Arrangement.spacedBy(20.dp),
                    modifier = Modifier.padding(top = 20.dp)
                ) {
                    RoundedSquareCard(color = Color.White) {
                        Text(
                            text = "-",
                            style = MaterialTheme.typography.titleLarge.copy(fontSize = 32.sp),
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                        )
                    }
                    RoundedSquareCard(color = Color.White) {
                        Text(
                            text = "1",
                            style = MaterialTheme.typography.labelLarge,
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                        )
                    }
                    RoundedSquareCard(color = Color.Black) {
                        Text(
                            text = "+",
                            style = MaterialTheme.typography.labelLarge,
                            color = Color.White,
                            textAlign = TextAlign.Center,
                        )
                    }
                }
                //endregion

                Box(Modifier.weight(1f),) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        Text(
                            text = "£16",
                            style = MaterialTheme.typography.titleLarge,
                            color = GoNutsCustomColors.current.onBackground
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Button(
                            onClick = { /*TODO*/ },
                            colors = ButtonDefaults
                                .buttonColors(GoNutsCustomColors.current.primary),
                            modifier = Modifier.fillMaxWidth()

                            ) {
                            Text(
                                text = "Add to Cart",
                                color = Color.White,
                                modifier = Modifier.padding(vertical = 12.dp)
                            )
                        }
                    }
                }
            }
            AddToFavouriteIcon(
                Modifier
                    .align(Alignment.TopEnd)
                    .graphicsLayer {
                        translationX = -100f
                        translationY = 125f
                    }
                    .shadow(
                        elevation = 4.dp,
                        shape = RoundedCornerShape(32),
                        spotColor = Color.Black.copy(alpha = .1f)
                    ),
                shape = RoundedCornerShape(32)
            )

        }
        //endregion

        //region back icon
        Image(
            painter = painterResource(id = R.drawable.ic_back),
            contentDescription = "back icon",
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(35.dp)
        )
        //endregion
    }
}

@Preview
@Composable
fun DoughnutDetailsContentPreview() {
    GoNutsTheme { DoughnutDetailsContent() }
}