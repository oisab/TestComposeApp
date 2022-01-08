package com.oisab.testcomposeapp.phonelogin.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.oisab.testcomposeapp.ui.theme.TestComposeTheme
import com.oisab.testcomposeapp.R
import com.oisab.testcomposeapp.phonelogin.PhoneLoginIntents
import com.oisab.testcomposeapp.phonelogin.PhoneLoginViewModel

@Composable
fun ErrorView(phoneLoginViewModel: PhoneLoginViewModel) {
    val myViewState by phoneLoginViewModel.phoneLoginViewState.observeAsState()
    Row(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .clip(RoundedCornerShape(13.dp))
            .background(TestComposeTheme.colors.indicatorContendError),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = myViewState!!.errorMessage,
            modifier = Modifier
                .wrapContentHeight()
                .weight(1F)
                .padding(start = 16.dp),
            textAlign = TextAlign.Start,
            style = TestComposeTheme.typography.caption13_1
        )
        IconButton(
            onClick = { phoneLoginViewModel.obtainIntent(intent = PhoneLoginIntents.HideError) },
            modifier = Modifier.size(48.dp)
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_close_24),
                contentDescription = "Error Close Icon",
                modifier = Modifier.size(16.dp),
                tint = Color.White,
            )
        }
    }
}