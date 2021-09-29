package com.example.liteprint.ui.screen.nesting_screen.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.liteprint.MainActivity
import com.example.liteprint.NestingScreenViewModel
import com.example.liteprint.ui.screen.main.BodyText

@Composable
fun NestingFooter(viewModel: NestingScreenViewModel, activity: MainActivity) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(
                shape = RoundedCornerShape(10.dp, 10.dp, 0.dp, 0.dp)
            )
            .background(
                color = Color.White
            )
    ) {
        Row(
            Modifier
                .padding(10.dp)
                .align(Alignment.Center)
        ) {
            Column(
                Modifier
                    .padding(10.dp)
                    .weight(1f)
            ) {

                BodyText(text = "Площадь:", fontSize = 12)
            }
            Column(
                Modifier
                    .padding(10.dp)
                    .weight(1f)
            ) {
                if (viewModel.isNested.value) {
                    val detailArea = viewModel.detailArea.value
                    val trimmedString = String.format("%.2f", detailArea.toDouble())
                    BodyText(text = "$trimmedString м2", fontSize = 12)
                }
            }
            Column(
                Modifier
                    .padding(10.dp)
                    .weight(1f)
            ) {

                BodyText(text = "Периметр:", fontSize = 12)
            }
            Column(
                Modifier
                    .padding(10.dp)
                    .weight(1f)
            ) {
                if (viewModel.isNested.value) {
                    val detailPerimeter = viewModel.detailPerimeter.value
                    BodyText(text = "$detailPerimeter п.м.", fontSize = 12)
                }
            }

        }
    }

    SendButton(viewModel = viewModel, activity = activity)
}