package com.oisab.testcomposeapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun TestComposeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val typography = testComposeTypography
    val colors = if (darkTheme)
        baseDarkPalette
    else baseLightPalette

    CompositionLocalProvider(
        LocalTestComposeColors provides colors,
        LocalTestComposeTypography provides typography,
        content = content
    )
}
