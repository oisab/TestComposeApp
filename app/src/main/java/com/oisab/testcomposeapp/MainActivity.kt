package com.oisab.testcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.navigationBarsWithImePadding
import com.oisab.testcomposeapp.phonelogin.PhoneLoginScreen
import com.oisab.testcomposeapp.phonepayment.MobileOperatorsScreen
import com.oisab.testcomposeapp.pinlogin.PinLoginScreen
import com.oisab.testcomposeapp.splash.SplashScreen
import com.oisab.testcomposeapp.ui.theme.*

class MainActivity : ComponentActivity() {
    @ExperimentalComposeUiApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            ProvideWindowInsets {
                TestComposeTheme {
                    // A surface container using the 'background' color from the theme
                    Surface(
                        color = TestComposeTheme.colors.primaryBackground,
                        modifier = Modifier.navigationBarsWithImePadding(),
                    ) {
                        val navController = rememberNavController()
                        SplashScreen(navController = navController)
                        NavHost(navController = navController, startDestination = "splashScreen") {
                            composable("splashScreen") { SplashScreen(navController) }
                            composable("phoneLoginScreen") { PhoneLoginScreen(navController = navController) }
                            composable("pinLoginScreen") { PinLoginScreen(navController = navController) }
                            composable("mobileOperatorsScreen") { MobileOperatorsScreen(navController = navController) }
                        }
                    }
                }
            }
        }
    }
}