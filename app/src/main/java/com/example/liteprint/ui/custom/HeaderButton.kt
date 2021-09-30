package com.example.liteprint.ui.custom

import DarkCarrot
import LightCarrot
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.example.liteprint.NestingScreenViewModel
import com.example.liteprint.ui.screen.main.HeaderText


@Composable
fun FlatMaterialButton(viewModel: NestingScreenViewModel) {

    Box(
        modifier = Modifier
            .fillMaxWidth(1f)
            .height(30.dp),
        contentAlignment = Alignment.Center
    ) {
        GradientButton(
            gradient = Brush.horizontalGradient(
                colors = listOf(
                    DarkCarrot,
                    LightCarrot
                )
            ),
            {
                    viewModel.setNestingType(NestingScreenViewModel.NestingType.FlatMaterialNest)
                    viewModel.onNestedChanged()
            },
            shape = RoundedCornerShape(0.dp, 0.dp, 0.dp, 5.dp)
        )

        HeaderText(text = "на лист", 18)

    }
}

@Composable
fun ScrollMaterialButton(viewModel: NestingScreenViewModel) {

    Box(
        modifier = Modifier
            .fillMaxWidth(1f)
            .height(30.dp),
        contentAlignment = Alignment.Center
    ) {
        GradientButton(
            gradient = Brush.horizontalGradient(
                colors = listOf(
                    LightCarrot,
                    DarkCarrot
                )
            ),
            {
                viewModel.setNestingType(NestingScreenViewModel.NestingType.ScrollMaterialNest)
                viewModel.onNestedChanged() },
            shape = RoundedCornerShape(0.dp, 0.dp, 5.dp, 0.dp)
        )
        HeaderText(text = "на рулон", 18)

    }
}
