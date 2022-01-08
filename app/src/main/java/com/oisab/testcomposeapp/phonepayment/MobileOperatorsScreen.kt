package com.oisab.testcomposeapp.phonepayment

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.oisab.testcomposeapp.R
import com.oisab.testcomposeapp.ui.theme.TestComposeTheme

@Composable
fun MobileOperatorsScreen(
    mobileOperatorsViewModel: MobileOperatorsViewModel = MobileOperatorsViewModel(),
    navController: NavController
) {
    val operators by mobileOperatorsViewModel.operators.observeAsState()
    var searchText by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .background(TestComposeTheme.colors.primaryBackground)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Row(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .background(TestComposeTheme.colors.primaryBackground),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(
                onClick = { navController.popBackStack() }, modifier = Modifier
                    .padding(top = 30.dp)
                    .size(48.dp)
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_back_24),
                    contentDescription = "Back Icon",
                    tint = TestComposeTheme.colors.buttonSecondary
                )
            }
            Text(
                text = "Мобильная связь",
                style = TestComposeTheme.typography.subtitle20Semibold,
                modifier = Modifier
                    .padding(top = 30.dp)
                    .wrapContentWidth()
                    .wrapContentHeight(),
                fontSize = 17.sp,
                maxLines = 1,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.size(48.dp))
        }

        TextInput(modifier = Modifier
            .padding(horizontal = 16.dp)
            .height(36.dp)
            .fillMaxWidth(),
            value = searchText,
            placeholder = "Поиск",
            onValueChanged = { searchText = it })

        LazyColumn(
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxSize()
                .background(TestComposeTheme.colors.secondaryBackground)
        ) {
            operators?.forEach { operator ->
                item { OperatorsListItem(operator) }
            }
        }
    }
}

@Composable
fun TextInput(
    modifier: Modifier = Modifier,
    value: String,
    placeholder: String,
    onValueChanged: (text: String) -> Unit,
) {
    var textFieldValueState by remember { mutableStateOf(TextFieldValue(text = value)) }
    val textFieldValue = textFieldValueState.copy(text = value)
    val interactionSource = remember { MutableInteractionSource() }
    val isFocused = interactionSource.collectIsFocusedAsState().value

    BasicTextField(
        value = textFieldValue,
        onValueChange = {
            textFieldValueState = it
            if (value != it.text) {
                onValueChanged(it.text)
            }
        },
        modifier = modifier.defaultMinSize(
            minHeight = TextFieldDefaults.MinHeight,
            minWidth = TextFieldDefaults.MinWidth
        ),
        singleLine = true,
        textStyle = TestComposeTheme.typography.body15Regular2,
        interactionSource = interactionSource,
        decorationBox = { innerTextField ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        TestComposeTheme.colors.contendSecondary,
                        RoundedCornerShape(8.dp)
                    ),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_search_24),
                    contentDescription = "Search Icon",
                    tint = TestComposeTheme.colors.searchIconPrimary,
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .align(Alignment.CenterVertically)
                        .padding(end = 4.dp)
                )
                if (value.isEmpty() && !isFocused)
                    Text(
                        text = placeholder,
                        style = TestComposeTheme.typography.body15Regular2,
                        color = TestComposeTheme.colors.textTertiary,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                else
                    innerTextField()
            }
        },
        cursorBrush = SolidColor(TestComposeTheme.colors.cursorColor),
    )
}


@Composable
fun OperatorsListItem(modelMobile: MobileOperatorModel) {
    Row(
        modifier = Modifier
            .height(67.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Image(
            painterResource(id = modelMobile.icon),
            contentDescription = modelMobile.name,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .size(40.dp)
        )
        Text(text = modelMobile.name, color = Color.White)
    }
}