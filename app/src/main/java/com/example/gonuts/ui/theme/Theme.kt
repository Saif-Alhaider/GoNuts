package com.example.gonuts.ui.theme

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = Primary700,
    onPrimary = Primary600,
    onPrimaryContainer = Primary300,
    background = BackgroundDark,
    onBackground = onBackground60Dark
)

private val LightColorScheme = lightColorScheme(
    primary = Primary700,
    onPrimary = Primary600,
    onPrimaryContainer = Primary300,
    background = BackgroundLight,
    onBackground = onBackground60Light,
)
private val onDarkCustomColorsPalette = CustomColorsPalette(
    primary = Primary700,
    onPrimary = Primary600,
    primaryBackground = Primary300,
    background = BackgroundDark,
    onBackground = onBackgroundDark,
    onBackground60 = onBackground60Dark,
    subtitle = Subtitle
)

private val onLightCustomColorsPalette = CustomColorsPalette(
    primary = Primary700,
    onPrimary = Primary600,
    primaryBackground = Primary300,
    background = BackgroundLight,
    onBackground = onBackgroundLight,
    onBackground60 = onBackground60Light,
    subtitle = Subtitle
)

@SuppressLint("CompositionLocalNaming")
val GoNutsCustomColors = staticCompositionLocalOf { CustomColorsPalette() }

@Composable
fun GoNutsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    val customColorsPalette =
        if (darkTheme) onDarkCustomColorsPalette
        else onLightCustomColorsPalette

    CompositionLocalProvider(
        GoNutsCustomColors provides customColorsPalette
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            content = content
        )
    }

}

