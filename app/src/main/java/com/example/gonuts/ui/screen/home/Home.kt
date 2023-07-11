package com.example.gonuts.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.gonuts.R
import com.example.gonuts.entity.Doughnut
import com.example.gonuts.ui.common.state.mapToUi
import com.example.gonuts.ui.screen.doughnut_details.navigateToDoughnutDetails
import com.example.gonuts.ui.screen.home.composables.DoughnutCard
import com.example.gonuts.ui.screen.home.composables.DoughnutMiniCard
import com.example.gonuts.ui.theme.GoNutsCustomColors
import com.example.gonuts.ui.theme.GoNutsTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun HomeScreen(navController: NavController) {
    val viewModel: HomeViewModel = hiltViewModel()
    val state = viewModel.state.collectAsState()
    HomeContent(onClickCard = { navController.navigateToDoughnutDetails(it) }, state = state.value)
}

@Composable
fun HomeContent(onClickCard: (String) -> Unit, state: HomeUiState) {
    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(
        color = GoNutsCustomColors.current.primary,
    )
    systemUiController.setNavigationBarColor(color = Color.Transparent)
    LazyColumn(
        Modifier
            .background(GoNutsCustomColors.current.background)
            .fillMaxSize(),
        contentPadding = PaddingValues(vertical = 16.dp)
    ) {
        //region header
        item {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(top = 64.dp, start = 32.dp, end = 32.dp)
                    .fillMaxWidth()
            ) {
                //region info
                Column {
                    Text(
                        text = "Let’s Gonuts!",
                        color = GoNutsCustomColors.current.primary,
                        style = MaterialTheme.typography.titleLarge
                    )
                    Text(
                        text = "Order your favourite donuts from here",
                        color = GoNutsCustomColors.current.onBackground60,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
                //endregion
                //region search button
                Image(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = "search icon",
                    modifier = Modifier
                        .clip(RoundedCornerShape(16.dp))
                        .clickable { }
                        .background(Color(0xFFFED8DF))
                        .padding(12.dp)
                )
                //endregion
            }
        }
        //endregion

        // region today offers section
        item {
            DoughnutSection(
                doughnuts = state.todayOffers,
                sectionTitle = "Today Offers",
                spaceByValue = 70.dp,
                contentPadding = PaddingValues(start = 32.dp, end = 80.dp),
            ) { doughnut ->
                DoughnutCard(
                    onClickCard = { onClickCard(doughnut.name) },
                    doughnut = doughnut,
                    color = doughnut.backgroundColor,
                )
            }
        }
        //endregion

        //region doughnuts section
        item {
            DoughnutSection(
                doughnuts = state.doughnuts,
                sectionTitle = "Donuts",
                spaceByValue = 23.dp,
                contentPadding = PaddingValues(start = 32.dp, end = 32.dp)
            ) { doughnut ->
                DoughnutMiniCard(
                    modifier = Modifier.padding(top = 20.dp),
                    doughnutName = doughnut.name,
                    doughnutImageRes = doughnut.tiltedViewImageResource,
                    onClick = { onClickCard(doughnut.name) },
                    doughnutPrice = doughnut.discountedPrice
                )
            }
        }
        //endregion
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun HomeContentPreview() {
    val todayOffers = listOf(
        Doughnut(
            name = "Strawberry Wheel",
            description = "These Baked Strawberry Donuts are filled with fresh strawberries...",
            originalPrice = 2.99,
            discountedPrice = 2.49,
            frontViewImageResource = R.drawable.doughnut_strawberry_wheel_sprinkles,
            backgroundColor = Color(0xFFD7E4F6),
            tiltedViewImageResource = R.drawable.doughnut_strawberry_chocolate_drizzle
        ),
        Doughnut(
            name = "Chocolate Glaze",
            description = "Moist and fluffy baked chocolate donuts full of chocolate flavor.",
            originalPrice = 3.49,
            discountedPrice = 2.99,
            frontViewImageResource = R.drawable.doughnut_chocolate_glaze_sprinkles,
            backgroundColor = Color(0xFFFFC7D0),
            tiltedViewImageResource = R.drawable.doughnut_strawberry_chocolate_drizzle
        ),
    )
    val doughnuts = listOf(
        Doughnut(
            name = "Chocolate Cherry",
            description = "",
            originalPrice = 13.9,
            discountedPrice = 8.7,
            frontViewImageResource = R.drawable.doughnut_chocolate_glaze_sprinkles,
            backgroundColor = Color(0xFFD7E4F6),
            tiltedViewImageResource = R.drawable.doughnut_chocolate_cherry_drizzle
        ),
        Doughnut(
            name = "Strawberry Rain",
            description = "",
            originalPrice = 16.5,
            discountedPrice = 10.0,
            frontViewImageResource = R.drawable.doughnut_strawberry_wheel_sprinkles,
            backgroundColor = Color(0xFFFFC7F6),
            tiltedViewImageResource = R.drawable.doughnut_strawberry_rain_sprinkles
        ),
        Doughnut(
            name = "Strawberry Snow",
            description = "",
            originalPrice = 30.0,
            discountedPrice = 15.6,
            frontViewImageResource = R.drawable.doughnut_strawberry_wheel_sprinkles,
            backgroundColor = Color(0xFFD7E4F6),
            tiltedViewImageResource = R.drawable.doughnut_strawberry_chocolate_drizzle
        ),
    )
    GoNutsTheme {
        HomeContent(
            onClickCard = {},
            HomeUiState(
                todayOffers = todayOffers.map { it.mapToUi() },
                doughnuts = doughnuts.map { it.mapToUi() }),
        )
    }
}