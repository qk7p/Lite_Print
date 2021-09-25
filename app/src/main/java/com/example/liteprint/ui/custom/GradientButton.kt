package com.example.liteprint.ui.custom


import DarkCarrot
import LightCarrot
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp



@Composable
fun GradientButton(
    gradient: Brush,
    onClick: () -> Unit
) {

    Button(shape = RoundedCornerShape(0.dp, 0.dp, 5.dp, 5.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent
        ),
        contentPadding = PaddingValues(),
        onClick = { onClick() })
    {
        Box(
            modifier = Modifier
                .background(gradient)
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .fillMaxSize(1f),
        ) {
        }
    }
}

@Preview
@Composable
fun GradientButtonPreview() {
    GradientButton(
        gradient = Brush.horizontalGradient(
            colors = listOf(
                DarkCarrot, LightCarrot
            )
        )
    ) {

    }
}