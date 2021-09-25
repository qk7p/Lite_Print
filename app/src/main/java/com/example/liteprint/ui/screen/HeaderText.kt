package com.example.liteprint.ui.screen.main

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.example.liteprint.ui.theme.RussoOne

@Composable
fun HeaderText (text: String, fontSize: Int)
{
    Text(
        text = text,
        fontFamily = RussoOne,
        color = Color.White,
        fontSize = fontSize.sp,
        maxLines = 1
    )
}