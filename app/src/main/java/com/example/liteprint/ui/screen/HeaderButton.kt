package com.example.liteprint.ui.screen.main

import DarkCarrot
import LightCarrot
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.example.liteprint.ui.custom.GradientButton


@Composable
fun HeaderButton() {

    Box(
        modifier = Modifier.fillMaxWidth(1f).height(30.dp),
        contentAlignment = Alignment.Center
    ) {
        GradientButton(
            gradient = Brush.horizontalGradient(
                colors = listOf(
                    DarkCarrot,
                    LightCarrot
                )
            ), {}
        )
HeaderText(text = "разложить", 18)

    }
}
