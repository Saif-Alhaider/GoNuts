package com.example.gonuts.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

val Primary700 = Color(0xFFFF7074)
val Primary600 = Color(0xFFFF9494)
val Primary300 = Color(0xFFFED8DF)

val BackgroundLight = Color.White
val BackgroundDark = Color.Black

val onBackgroundLight = Color.Black
val onBackground60Light = Color.Black.copy(alpha = .6f)

val onBackgroundDark = Color.White
val onBackground60Dark = Color.White.copy(alpha = .6f)

@Immutable
data class CustomColorsPalette(
    val primary: androidx.compose.ui.graphics.Color = androidx.compose.ui.graphics.Color.Unspecified,
    val onPrimary: androidx.compose.ui.graphics.Color = androidx.compose.ui.graphics.Color.Unspecified,
    val onPrimaryContainer: androidx.compose.ui.graphics.Color = androidx.compose.ui.graphics.Color.Unspecified,
    val background: androidx.compose.ui.graphics.Color = androidx.compose.ui.graphics.Color.Unspecified,
    val onBackground: androidx.compose.ui.graphics.Color = androidx.compose.ui.graphics.Color.Unspecified,
    val onBackground60: androidx.compose.ui.graphics.Color = androidx.compose.ui.graphics.Color.Unspecified,
)