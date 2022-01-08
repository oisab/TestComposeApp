package com.oisab.testcomposeapp.ui.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.oisab.testcomposeapp.R

private val sfProDisplayFonts = FontFamily(
    Font(R.font.sf_pro_display_bold, weight = FontWeight.Bold, style = FontStyle.Normal),
    Font(R.font.sf_pro_display_medium, weight = FontWeight.Medium, style = FontStyle.Normal),
    Font(R.font.sf_pro_display_semibold, weight = FontWeight.SemiBold, style = FontStyle.Normal),
    Font(R.font.sf_pro_display_regular, weight = FontWeight.Normal, style = FontStyle.Normal),
)

private val sfProTextFonts = FontFamily(
    Font(R.font.sf_pro_text_semibold, weight = FontWeight.SemiBold, style = FontStyle.Normal),
    Font(R.font.sf_pro_text_regular, weight = FontWeight.Normal, style = FontStyle.Normal),
)

val testComposeTypography = TestComposeTypography(
    title34Bold = TextStyle(
        fontFamily = sfProDisplayFonts,
        color = Color.White,
        fontWeight = FontWeight.Bold,
        fontSize = 34.sp,
        lineHeight = 41.sp,
        letterSpacing = 0.41.sp,
    ),
    title34Regular = TextStyle(
        fontFamily = sfProDisplayFonts,
        color = Color.White,
        fontWeight = FontWeight.Normal,
        fontSize = 34.sp,
        lineHeight = 41.sp,
        letterSpacing = 0.41.sp,
    ),
    largeTitle28Medium = TextStyle(
        fontFamily = sfProDisplayFonts,
        color = Color.White,
        fontWeight = FontWeight.Medium,
        fontSize = 28.sp,
        lineHeight = 34.sp,
        letterSpacing = 0.34.sp,
    ),
    subtitle20Semibold = TextStyle(
        fontFamily = sfProDisplayFonts,
        color = Color.White,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        lineHeight = 25.sp,
        letterSpacing = 0.38.sp,
    ),
    body20Regular = TextStyle(
        fontFamily = sfProDisplayFonts,
        color = Color.White,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
        lineHeight = 25.sp,
        letterSpacing = 0.38.sp,
    ),
    body17Medium = TextStyle(
        fontFamily = sfProTextFonts,
        color = Color.White,
        fontWeight = FontWeight.Medium,
        fontSize = 17.sp,
        lineHeight = 22.sp,
        letterSpacing = (-0.41).sp,
    ),
    body17Regular1 = TextStyle(
        fontFamily = sfProTextFonts,
        color = Color.White,
        fontWeight = FontWeight.Normal,
        fontSize = 17.sp,
        lineHeight = 22.sp,
        letterSpacing = (-0.41).sp,
    ),
    body15Regular2 = TextStyle(
        fontFamily = sfProTextFonts,
        color = Color.White,
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp,
        lineHeight = 20.sp,
        letterSpacing = (-0.24).sp,
    ),
    body15Semibold = TextStyle(
        fontFamily = sfProTextFonts,
        color = Color.White,
        fontWeight = FontWeight.SemiBold,
        fontSize = 15.sp,
        lineHeight = 20.sp,
        letterSpacing = (-0.24).sp,
    ),
    caption13_1 = TextStyle(
        fontFamily = sfProTextFonts,
        color = Color.White,
        fontWeight = FontWeight.Normal,
        fontSize = 13.sp,
        lineHeight = 16.sp,
        letterSpacing = (-0.08).sp,
    ),
    caption11_2 = TextStyle(
        fontFamily = sfProTextFonts,
        color = Color.White,
        fontWeight = FontWeight.Normal,
        fontSize = 11.sp,
        lineHeight = 14.sp,
        letterSpacing = 0.07.sp,
    ),
    buttonTextStyle = TextStyle(
        fontFamily = sfProTextFonts,
        color = Color.White,
        fontWeight = FontWeight.SemiBold,
        fontSize = 15.sp,
        lineHeight = 18.sp,
        letterSpacing = (-0.41).sp,
    )
)