package com.example.mynotes.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Color(0xFFE24462),
    primaryVariant = Color(0xFFE24462),
    secondary = Color(0xFFA24462),
    onPrimary = Color.White
)

private val LightColorPalette = lightColors(
    primary = Color(0xFFE24462),
    primaryVariant = Color(0xFFE24462),
    secondary = Color(0xFFE24462)
)

@Composable
fun MyNotesTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        shapes = Shapes,
        content = content
    )
}

object MyNotesThemeSettings {
    var isDarkThemeEnabled by mutableStateOf(false)
}