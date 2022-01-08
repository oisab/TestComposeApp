package com.oisab.testcomposeapp.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle

data class TestComposeColors(
    val primaryBackground: Color,
    val secondaryBackground: Color,
    val contendPrimary: Color,
    val contendSecondary: Color,
    val contendTertiary: Color,
    val contendAccentPrimary: Color,
    val contendAccentSecondary: Color,
    val contendAccentTertiary: Color,
    val textPrimary: Color,
    val textSecondary: Color,
    val textTertiary: Color,
    val indicatorContendError: Color,
    val indicatorContendDone: Color,
    val indicatorContendSuccess: Color,
    val buttonPrimary: Color,
    val buttonSecondary: Color,
    val backgroundBottomMenu: Color,
    val screamer: Color,
    val calendarPeriod: Color,
    val searchIconPrimary: Color,
    val cursorColor: Color,
    val textButton: Color = Color(0xFFFFFFFF),
    val black: Color = Color(0xFF000000),
)

data class TestComposeTypography(
    val title34Bold: TextStyle,
    val title34Regular: TextStyle,
    val largeTitle28Medium: TextStyle,
    val subtitle20Semibold: TextStyle,
    val body20Regular: TextStyle,
    val body17Medium: TextStyle,
    val body17Regular1: TextStyle,
    val body15Regular2: TextStyle,
    val body15Semibold: TextStyle,
    val caption13_1: TextStyle,
    val caption11_2: TextStyle,
    val buttonTextStyle: TextStyle,
)

object TestComposeTheme {
    val colors: TestComposeColors
        @Composable
        get() = LocalTestComposeColors.current

    val typography: TestComposeTypography
        @Composable
        get() = LocalTestComposeTypography.current
}

val LocalTestComposeColors = staticCompositionLocalOf<TestComposeColors> { error("No colors provided") }
val LocalTestComposeTypography = staticCompositionLocalOf<TestComposeTypography> { error("No typography provided") }
