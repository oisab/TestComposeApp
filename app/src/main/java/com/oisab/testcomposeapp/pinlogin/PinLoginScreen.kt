package com.oisab.testcomposeapp.pinlogin

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.material.ButtonDefaults
import androidx.navigation.NavController
import com.oisab.testcomposeapp.R
import com.oisab.testcomposeapp.ui.theme.TestComposeTheme

@Composable
fun PinLoginScreen(
    pinLoginViewModel: PinLoginViewModel = PinLoginViewModel(),
    navController: NavController
) {
    val showPassword = remember {
        mutableStateOf(false)
    }
    val password by pinLoginViewModel.password.observeAsState()
    val errorState by pinLoginViewModel.isErrorState.observeAsState()
    Column(
        modifier = Modifier
            .background(TestComposeTheme.colors.secondaryBackground)
            .fillMaxSize(),
    ) {
        Row(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(
                onClick = { navController.popBackStack() },
                modifier = Modifier
                    .padding(start = 4.dp, top = 18.dp)
                    .size(48.dp)
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_left_24),
                    contentDescription = "Left Icon",
                    tint = TestComposeTheme.colors.buttonSecondary,
                )
            }
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.img_logo_90x101),
                contentDescription = "Logo Image",
                modifier = Modifier
                    .offset(y = 31.dp),
                tint = if (isSystemInDarkTheme())
                    TestComposeTheme.colors.contendAccentTertiary
                else TestComposeTheme.colors.contendAccentPrimary
            )
            Spacer(modifier = Modifier.size(48.dp))
        }
        Text(
            text = "Введите пароль",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(top = 61.dp, start = 16.dp, end = 16.dp),
            style = TestComposeTheme.typography.body15Regular2,
            color = if (errorState == true) TestComposeTheme.colors.indicatorContendError else Color.White
        )
        TextField(
            value = password!!,
            onValueChange = { newValue -> pinLoginViewModel.setPassword(newValue = newValue) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, top = 22.dp, end = 16.dp),
            shape = RoundedCornerShape(26.dp),
            singleLine = true,
            textStyle = TestComposeTheme.typography.body15Regular2,
            placeholder = {
                Text(
                    text = "Пароль",
                    style = TestComposeTheme.typography.body15Regular2,
                    color = if (errorState == true) TestComposeTheme.colors.indicatorContendError else TestComposeTheme.colors.textTertiary
                )
            },
            leadingIcon = {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_lock_24),
                    contentDescription = "Lock Icon",
                    modifier = Modifier.padding(start = 24.dp, end = 16.dp),
                    tint = if (errorState == true) TestComposeTheme.colors.indicatorContendError else TestComposeTheme.colors.contendAccentPrimary
                )
            },
            trailingIcon = {
                IconButton(
                    onClick = { showPassword.value = !showPassword.value },
                    modifier = Modifier.padding(end = 16.dp),
                ) {
                    Icon(
                        imageVector = if (showPassword.value)
                            ImageVector.vectorResource(id = R.drawable.ic_eye_24)
                        else
                            ImageVector.vectorResource(id = R.drawable.ic_eye_close_24),
                        contentDescription = "Show Password Icon",
                        tint = TestComposeTheme.colors.contendTertiary,
                    )
                }
            },
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                backgroundColor = TestComposeTheme.colors.contendPrimary,
                textColor = if (errorState == true) TestComposeTheme.colors.indicatorContendError else Color.White
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                autoCorrect = false
            ),
            visualTransformation = if (showPassword.value)
                VisualTransformation.None
            else
                PasswordVisualTransformation()

        )
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.BottomCenter,
        ) {
            Button(
                onClick = {
//                    if (pinLoginViewModel.validatePassword(password!!)) {
//                        navController.navigate("mobileOperatorsScreen")
//                    } else {
//                        pinLoginViewModel.setErrorState(true)
//                    }
                    navController.navigate("mobileOperatorsScreen")
                }, modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 24.dp)
                    .height(52.dp),
                shape = RoundedCornerShape(26.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = TestComposeTheme.colors.contendAccentPrimary)
            ) {
                Text(
                    text = "Войти",
                    textAlign = TextAlign.Center,
                    style = TestComposeTheme.typography.buttonTextStyle,
                )
            }
            if (errorState == true)
                Text(
                    text = "Забыли пароль?",
                    Modifier
                        .padding(vertical = 16.dp)
                        .clickable {
                            TODO("Navigate to Forgot Password Screen")
                        },
                    style = TestComposeTheme.typography.body15Semibold,
                    color = TestComposeTheme.colors.contendTertiary
                )
        }
    }
}