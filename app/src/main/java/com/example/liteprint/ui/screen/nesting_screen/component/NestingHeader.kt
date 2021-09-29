package com.example.liteprint.ui.screen.nesting_screen.component

import DarkBlue
import LightBlue
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.example.liteprint.NestingScreenViewModel
import com.example.liteprint.ui.custom.HeaderTextField
import com.example.liteprint.ui.screen.main.FlatMaterialButton
import com.example.liteprint.ui.screen.main.HeaderText
import com.example.liteprint.ui.screen.main.ScrollMaterialButton

@Composable
fun NestingHeader(viewModel: NestingScreenViewModel) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(10.dp, 10.dp, 0.dp, 0.dp))
            .background(
                brush = (
                        Brush.verticalGradient(
                            colors = listOf(DarkBlue, LightBlue)
                        )
                        )
            )
    ) {
        Row(Modifier.padding(16.dp)) {
            Column(
                Modifier
                    .padding(16.dp)
                    .weight(1f)
            ) {
                HeaderText(text = "Ширина изделия:", 12)
                val detailWidth = viewModel.getDetailWidthString()
                HeaderTextField(detailWidth, viewModel::setDetailWidth)

                Spacer(modifier = Modifier.height(10.dp))

                HeaderText(text = "Вылеты изделия:", 12)
                val detailMarginState = viewModel.getDetailMarginString()
                HeaderTextField(text = detailMarginState, viewModel::setDetailMargin)

            }
            Column(
                Modifier
                    .padding(16.dp)
                    .weight(1f)
            ) {
                HeaderText(text = "Высота изделия:", 12)
                val detailHeight = viewModel.getDetailHeightString()
                HeaderTextField(text = detailHeight, viewModel::setDetailHeight)

                Spacer(modifier = Modifier.height(10.dp))

                HeaderText(text = "Вылеты заготовки:", 12)
                val materialMargin = viewModel.getMaterialMarginString()
                HeaderTextField(text = materialMargin, viewModel::onMaterialMarginChanged)
            }
        }
    }

    Row() {
        Column(modifier = Modifier.weight(1f)) {
            FlatMaterialButton(viewModel = viewModel)
        }
        Column(modifier = Modifier.weight(1f)) {
            ScrollMaterialButton(viewModel = viewModel)
        }
    }
}
