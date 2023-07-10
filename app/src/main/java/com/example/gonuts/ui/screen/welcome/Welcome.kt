package com.example.gonuts.ui.screen.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gonuts.R
import com.example.gonuts.ui.theme.GoNutsCustomColors
import com.example.gonuts.ui.theme.GoNutsTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun WelcomeContent() {
    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(
        color = GoNutsCustomColors.current.primaryBackground,
    )
    systemUiController.setNavigationBarColor(color = GoNutsCustomColors.current.primaryBackground)
    Box(
        modifier = Modifier
            .background(color = GoNutsCustomColors.current.primaryBackground)
            .fillMaxSize()
    ) {
        //region header
        Box(
            Modifier
                .fillMaxHeight(.4f)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.doughnut_group),
                contentDescription = "group of doughnut",
                modifier = Modifier
                    .matchParentSize()
                    .scale(1.6f, 1.5f)
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
        //endregion

        //region body
        Column(
            Modifier
                .fillMaxHeight(.6f)
                .align(Alignment.BottomCenter)
                .padding(horizontal = 40.dp)

        ) {
            Text(
                text = "Gonuts\nwith\nDonuts",
                style = MaterialTheme.typography.displayLarge,
                color = GoNutsCustomColors.current.primary,
            )
            Text(
                text = "Gonuts with Donuts is a Sri Lanka dedicated food outlets for specialize manufacturing of Donuts in Colombo, Sri Lanka.",
                color = GoNutsCustomColors.current.subtitle,
                style = MaterialTheme.typography.bodyLarge
            )
            Box(Modifier.weight(1f)) {
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black
                    ),
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 40.dp)

                ) {
                    Text(
                        text = "Get Started",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.labelMedium,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )
                }
            }
        }
        //endregion
    }
}

@Preview(showSystemUi = true)
@Composable
fun WelcomeContentPreview() {
    GoNutsTheme { WelcomeContent() }

}