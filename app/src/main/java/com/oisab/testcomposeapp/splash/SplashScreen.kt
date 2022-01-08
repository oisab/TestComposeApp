package com.oisab.testcomposeapp.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.oisab.testcomposeapp.R
import com.oisab.testcomposeapp.ui.theme.TestComposeTheme

@Composable
fun SplashScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(TestComposeTheme.colors.primaryBackground)
            .clickable {
                navController.navigate("phoneLoginScreen")
            },
        contentAlignment = Alignment.Center,
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.img_logo_171x192),
            contentDescription = "Logo Image",
            tint = if (isSystemInDarkTheme())
                TestComposeTheme.colors.contendAccentTertiary
            else TestComposeTheme.colors.contendAccentPrimary,
        )
    }
}