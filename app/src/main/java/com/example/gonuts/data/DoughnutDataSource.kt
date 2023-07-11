package com.example.gonuts.data

import androidx.compose.ui.graphics.Color
import com.example.gonuts.R
import com.example.gonuts.di.ResourcesProvider
import com.example.gonuts.entity.Doughnut
import javax.inject.Inject

class DoughnutDataSource @Inject constructor(
    resourcesProvider: ResourcesProvider
) {
    val todayOffers = listOf(
        Doughnut(
            name = "Strawberry Wheel",
            description = "These Baked Strawberry Donuts are filled with fresh strawberries...",
            originalPrice = 2.99,
            discountedPrice = 2.49,
            frontViewImageResource = resourcesProvider
                .getDrawable(R.drawable.doughnut_strawberry_wheel_sprinkles),
            backgroundColor = Color(0xFFD7E4F6),
            tiltedViewImageResource = resourcesProvider
                .getDrawable(R.drawable.doughnut_strawberry_chocolate_drizzle)
        ),
        Doughnut(
            name = "Chocolate Glaze",
            description = "Moist and fluffy baked chocolate donuts full of chocolate flavor.",
            originalPrice = 3.49,
            discountedPrice = 2.99,
            frontViewImageResource = resourcesProvider
                .getDrawable(R.drawable.doughnut_chocolate_glaze_sprinkles),
            backgroundColor = Color(0xFFFFC7D0),
            tiltedViewImageResource = resourcesProvider
                .getDrawable(R.drawable.doughnut_strawberry_chocolate_drizzle)
        ),
        Doughnut(
            name = "Blueberry Burst",
            description = "Delicious blueberry-filled doughnut topped with a sweet glaze.",
            originalPrice = 2.49,
            discountedPrice = 1.99,
            frontViewImageResource = resourcesProvider.getDrawable(R.drawable.doughnut_blueberry),
            backgroundColor = Color(0xFFFFC7F6),
            tiltedViewImageResource = resourcesProvider
                .getDrawable(R.drawable.doughnut_strawberry_chocolate_drizzle)

        ),
        Doughnut(
            name = "Peanut Butter Delight",
            description = "Irresistible doughnut filled with creamy peanut butter and topped with crushed peanuts.",
            originalPrice = 3.49,
            discountedPrice = 2.99,
            frontViewImageResource = resourcesProvider.getDrawable(R.drawable.doughnut_peanut_butter),
            backgroundColor = Color(0xFFFFF3C7),
            tiltedViewImageResource = resourcesProvider
                .getDrawable(R.drawable.doughnut_strawberry_chocolate_drizzle)
        ),
    )

    val doughnuts = listOf(
        Doughnut(
            name = "Chocolate Cherry",
            description = "Moist and fluffy baked chocolate donuts full of chocolate flavor.",
            originalPrice = 13.9,
            discountedPrice = 8.7,
            frontViewImageResource = resourcesProvider
                .getDrawable(R.drawable.doughnut_chocolate_glaze_sprinkles),
            backgroundColor = Color(0xFFD7E4F6),
            tiltedViewImageResource = resourcesProvider
                .getDrawable(R.drawable.doughnut_chocolate_cherry_drizzle)
        ),
        Doughnut(
            name = "Strawberry Rain",
            description = "Moist and fluffy baked chocolate donuts full of chocolate flavor.",
            originalPrice = 16.5,
            discountedPrice = 10.0,
            frontViewImageResource = resourcesProvider
                .getDrawable(R.drawable.doughnut_strawberry_wheel_sprinkles),
            backgroundColor = Color(0xFFFFC7F6),
            tiltedViewImageResource = resourcesProvider
                .getDrawable(R.drawable.doughnut_strawberry_rain_sprinkles)
        ),
        Doughnut(
            name = "Strawberry Snow",
            description = "Moist and fluffy baked chocolate donuts full of chocolate flavor.",
            originalPrice = 30.0,
            discountedPrice = 15.6,
            frontViewImageResource = resourcesProvider
                .getDrawable(R.drawable.doughnut_strawberry_wheel_sprinkles),
            backgroundColor = Color(0xFFD7E4F6),
            tiltedViewImageResource = resourcesProvider
                .getDrawable(R.drawable.doughnut_strawberry_chocolate_drizzle)
        ),
    )

}