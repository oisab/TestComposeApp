package com.oisab.testcomposeapp.phonelogin

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.oisab.testcomposeapp.R
import com.oisab.testcomposeapp.phonelogin.view.ErrorView
import com.oisab.testcomposeapp.phonelogin.view.LoginKeyboardView
import com.oisab.testcomposeapp.ui.theme.*

@ExperimentalComposeUiApi
@Composable
fun PhoneLoginScreen(
    phoneLoginViewModel: PhoneLoginViewModel = PhoneLoginViewModel(),
    navController: NavController
) {
    val viewState by phoneLoginViewModel.phoneLoginViewState.observeAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(TestComposeTheme.colors.secondaryBackground),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(TestComposeTheme.colors.secondaryBackground),
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.img_logo_90x101),
                contentDescription = "Logo Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .background(TestComposeTheme.colors.secondaryBackground)
                    .padding(top = 44.dp),
                tint = if (isSystemInDarkTheme())
                    TestComposeTheme.colors.contendAccentTertiary
                else TestComposeTheme.colors.contendAccentPrimary
            )
            if (viewState!!.isErrorState) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(y = 32.dp)
                        .height(66.dp)
                        .padding(horizontal = 16.dp)
                ) {
                    ErrorView(
                        phoneLoginViewModel
                    )
                }
            }
        }
        TextField(
            value = viewState!!.phoneNumber,
            onValueChange = { newValue -> phoneLoginViewModel.obtainIntent(PhoneLoginIntents.AddDigit(newValue))
                            Log.e("TAG", "${viewState!!}")},
            shape = RoundedCornerShape(26.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 52.dp)
                .onFocusChanged { focusState ->
                    if (focusState.isFocused)
                        phoneLoginViewModel.obtainIntent(intent = PhoneLoginIntents.ShowKeyboard)
                    else
                        phoneLoginViewModel.obtainIntent(intent = PhoneLoginIntents.HideKeyboard)

                },
            singleLine = true,
            textStyle = TestComposeTheme.typography.body15Regular2,
            placeholder = {
                Text(
                    "Телефон",
                    style = TestComposeTheme.typography.body15Regular2,
                    color = TestComposeTheme.colors.textTertiary
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                backgroundColor = TestComposeTheme.colors.contendPrimary
            ),
            leadingIcon = {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_phone_24),
                    contentDescription = "Phone Icon",
                    tint = TestComposeTheme.colors.contendAccentPrimary,
                    modifier = Modifier.padding(start = 24.dp, end = 16.dp),
                )
            },
        )
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Bottom) {
            Button(
                onClick = {
                          navController.navigate("pinLoginScreen")
                }, modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 24.dp)
                    .height(52.dp),
                shape = RoundedCornerShape(52.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = TestComposeTheme.colors.contendAccentPrimary)
            ) {
                Text(
                    text = "Войти",
                    textAlign = TextAlign.Center,
                    style = TestComposeTheme.typography.buttonTextStyle
                )
            }
            if (viewState!!.keyboardVisibility) {
                Log.e("TAG", "before show ${viewState!!.keyboardVisibility}")
                LoginKeyboardView(phoneLoginViewModel)
                Log.e("TAG", "after show ${viewState!!.keyboardVisibility}")
            }
        }
    }
}