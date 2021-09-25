package com.example.liteprint.ui.custom

import DarkBlue
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.liteprint.ui.theme.RussoOne

@Composable
fun HeaderTextField(state: MutableState<String>) {

    BasicTextField(
        value = state.value, onValueChange = { state.value = it },
        modifier = Modifier
            .background(
                color = Color.White,
                shape = RoundedCornerShape(5.dp)
            )
            .size(250.dp, 30.dp)
            .border(
                width = 2.dp,
                brush = Brush.horizontalGradient(
                    listOf(
                        Color.LightGray,
                        Color.White
                    )
                ),
                shape = RoundedCornerShape(5.dp)
            )
            .padding(5.dp),
        textStyle = TextStyle(
            color = DarkBlue,
            fontFamily = RussoOne,
            fontSize = 16.sp,
            textAlign = TextAlign.Start
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Done
        ),
        singleLine = true
    )
}

