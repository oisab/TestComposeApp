package com.oisab.testcomposeapp.phonelogin.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.material.ButtonDefaults
import androidx.compose.ui.unit.dp
import com.oisab.testcomposeapp.R
import com.oisab.testcomposeapp.phonelogin.PhoneLoginIntents
import com.oisab.testcomposeapp.phonelogin.PhoneLoginViewModel
import com.oisab.testcomposeapp.ui.theme.TestComposeTheme

@Composable
fun LoginKeyboardView(phoneNumberViewModel: PhoneLoginViewModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .background(TestComposeTheme.colors.primaryBackground),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Button(
                onClick = { phoneNumberViewModel.obtainIntent(PhoneLoginIntents.AddDigit("1")) },
                modifier = Modifier
                    .height(68.dp)
                    .fillMaxWidth()
                    .weight(1F),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = TestComposeTheme.colors.primaryBackground,
                    contentColor = TestComposeTheme.colors.textButton
                )
            ) {
                Text(
                    text = "1",
                    style = TestComposeTheme.typography.title34Regular
                )
            }
            Button(
                onClick = { phoneNumberViewModel.obtainIntent(PhoneLoginIntents.AddDigit("2")) },
                modifier = Modifier
                    .height(68.dp)
                    .fillMaxWidth()
                    .weight(1F),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = TestComposeTheme.colors.primaryBackground,
                    contentColor = TestComposeTheme.colors.textButton
                )
            ) {
                Text(
                    text = "2",
                    style = TestComposeTheme.typography.title34Regular
                )
            }
            Button(
                onClick = { phoneNumberViewModel.obtainIntent(PhoneLoginIntents.AddDigit("3")) },
                modifier = Modifier
                    .height(68.dp)
                    .fillMaxWidth()
                    .weight(1F),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = TestComposeTheme.colors.primaryBackground,
                    contentColor = TestComposeTheme.colors.textButton
                )
            ) {
                Text(
                    text = "3",
                    style = TestComposeTheme.typography.title34Regular
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Button(
                onClick = { phoneNumberViewModel.obtainIntent(PhoneLoginIntents.AddDigit("4")) },
                modifier = Modifier
                    .height(68.dp)
                    .fillMaxWidth()
                    .weight(1F),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = TestComposeTheme.colors.primaryBackground,
                    contentColor = TestComposeTheme.colors.textButton
                )
            ) {
                Text(
                    text = "4",
                    style = TestComposeTheme.typography.title34Regular
                )
            }
            Button(
                onClick = { phoneNumberViewModel.obtainIntent(PhoneLoginIntents.AddDigit("5")) },
                modifier = Modifier
                    .height(68.dp)
                    .fillMaxWidth()
                    .weight(1F),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = TestComposeTheme.colors.primaryBackground,
                    contentColor = TestComposeTheme.colors.textButton
                )
            ) {
                Text(
                    text = "5",
                    style = TestComposeTheme.typography.title34Regular
                )
            }
            Button(
                onClick = { phoneNumberViewModel.obtainIntent(PhoneLoginIntents.AddDigit("6")) },
                modifier = Modifier
                    .height(68.dp)
                    .fillMaxWidth()
                    .weight(1F),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = TestComposeTheme.colors.primaryBackground,
                    contentColor = TestComposeTheme.colors.textButton
                )
            ) {
                Text(
                    text = "6",
                    style = TestComposeTheme.typography.title34Regular
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Button(
                onClick = { phoneNumberViewModel.obtainIntent(PhoneLoginIntents.AddDigit("7")) },
                modifier = Modifier
                    .height(68.dp)
                    .fillMaxWidth()
                    .weight(1F),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = TestComposeTheme.colors.primaryBackground,
                    contentColor = TestComposeTheme.colors.textButton
                )
            ) {
                Text(
                    text = "7",
                    style = TestComposeTheme.typography.title34Regular
                )
            }
            Button(
                onClick = { phoneNumberViewModel.obtainIntent(PhoneLoginIntents.AddDigit("8")) },
                modifier = Modifier
                    .height(68.dp)
                    .fillMaxWidth()
                    .weight(1F),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = TestComposeTheme.colors.primaryBackground,
                    contentColor = TestComposeTheme.colors.textButton
                )
            ) {
                Text(
                    text = "8",
                    style = TestComposeTheme.typography.title34Regular
                )
            }
            Button(
                onClick = { phoneNumberViewModel.obtainIntent(PhoneLoginIntents.AddDigit("9")) },
                modifier = Modifier
                    .height(68.dp)
                    .fillMaxWidth()
                    .weight(1F),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = TestComposeTheme.colors.primaryBackground,
                    contentColor = TestComposeTheme.colors.textButton
                )
            ) {
                Text(
                    text = "9",
                    style = TestComposeTheme.typography.title34Regular
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Button( onClick = { phoneNumberViewModel.obtainIntent(PhoneLoginIntents.HideKeyboard) },
                modifier = Modifier
                    .height(68.dp)
                    .fillMaxWidth()
                    .weight(1F),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = TestComposeTheme.colors.primaryBackground,
                    contentColor = TestComposeTheme.colors.textButton
                )
            ) {
                Text(
                    text = "Отмена",
                    style = TestComposeTheme.typography.caption13_1
                )
            }
            Button(
                onClick = { phoneNumberViewModel.obtainIntent(PhoneLoginIntents.AddDigit("0")) },
                modifier = Modifier
                    .height(68.dp)
                    .fillMaxWidth()
                    .weight(1F),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = TestComposeTheme.colors.primaryBackground,
                    contentColor = TestComposeTheme.colors.textButton
                )
            ) {
                Text(
                    text = "0",
                    style = TestComposeTheme.typography.title34Regular
                )
            }
            Button(
                onClick = { phoneNumberViewModel.obtainIntent(PhoneLoginIntents.DeleteDigit) },
                modifier = Modifier
                    .height(68.dp)
                    .fillMaxWidth()
                    .weight(1F),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = TestComposeTheme.colors.primaryBackground,
                    contentColor = TestComposeTheme.colors.textButton
                )
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_delete_24),
                    contentDescription = "Delete Icon",
                    tint = TestComposeTheme.colors.textButton
                )
            }
        }
    }
}