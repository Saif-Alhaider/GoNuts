package com.example.gonuts.ui.screen.doughnut_details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.gonuts.R
import com.example.gonuts.ui.common.composables.AddToFavouriteIcon
import com.example.gonuts.ui.common.state.DoughnutUiState
import com.example.gonuts.ui.screen.doughnut_details.composables.RoundedSquareCard
import com.example.gonuts.ui.screen.home.AmountSelectorListener
import com.example.gonuts.ui.theme.GoNutsCustomColors
import com.example.gonuts.ui.theme.GoNutsTheme

@Composable
fun DoughnutDetailsScreen(navController: NavController) {
    val viewModel: DoughnutDetailsViewModel = hiltViewModel()
    DoughnutDetailsContent(
        onClickBack = navController::popBackStack,
        state = viewModel.state.collectAsState().value,
        amountSelectorListener = viewModel
    )
}

@Composable
fun DoughnutDetailsContent(
    onClickBack: () -> Unit,
    state: DoughnutDetailsUiState,
    amountSelectorListener: AmountSelectorListener
) {
    Box(modifier = Modifier.fillMaxSize()) {
        //region upper
        Column(
            Modifier
                .background(state.doughnut.backgroundColor)
                .fillMaxWidth()
                .fillMaxHeight(.5f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = state.doughnut.frontViewImageResource),
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
                    text = state.doughnut.name,
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
                    text = state.doughnut.description,
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
                    RoundedSquareCard(
                        color = Color.White,
                        onClick = amountSelectorListener::onClickDecrement,
                        text = "-"
                    )
                    RoundedSquareCard(color = Color.White, text = state.amount.toString())
                    RoundedSquareCard(
                        color = Color.Black,
                        onClick = amountSelectorListener::onClickIncrement,
                        text = "+",
                        textColor = Color.White
                    )
                }
                //endregion
                Box(Modifier.weight(1f)) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        Text(
                            text = "£${(state.amount * state.doughnut.discountedPrice).toString().format(".%1f")}",
                            style = MaterialTheme.typography.titleLarge,
                            color = GoNutsCustomColors.current.onBackground,
                            modifier = Modifier.width(90.dp),
                            overflow = TextOverflow.Ellipsis,
                            maxLines = 1
                        )
                        Spacer(modifier = Modifier.width(22.dp))
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
                .padding(35.dp,top=60.dp)
                .align(Alignment.TopStart)
                .clickable(onClick = onClickBack)
        )
        //endregion
    }
}

@Preview
@Composable
fun DoughnutDetailsContentPreview() {
    GoNutsTheme {
        DoughnutDetailsContent(
            onClickBack = {}, state = DoughnutDetailsUiState(
                doughnut = DoughnutUiState(
                    name = "Strawberry Wheel",
                    description = "These Baked Strawberry Donuts are filled with fresh strawberries...",
                    originalPrice = 2.99,
                    discountedPrice = 2.49,
                    backgroundColor = Color(0xFFD7E4F6)
                )
            ),
            amountSelectorListener = object : AmountSelectorListener {
                override fun onClickIncrement() {
                    TODO("Not yet implemented")
                }

                override fun onClickDecrement() {
                    TODO("Not yet implemented")
                }
            }
        )
    }
}