package com.example.liteprint.ui.screen.nesting_screen.component

import DarkBlue
import LightBlue
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.liteprint.NestingScreenViewModel
import com.example.liteprint.model.Detail
import com.example.liteprint.ui.screen.FlatMaterialCard
import com.example.liteprint.ui.screen.main.HeaderText

@Composable
fun FlatMaterialNestingList(viewModel: NestingScreenViewModel) {
    Column(
        Modifier
            .padding(5.dp)

    ) {

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
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth(1f)
            ) {
                HeaderText(text = "на заготовке", fontSize = 14)
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(
                    shape = RoundedCornerShape(0.dp, 0.dp, 10.dp, 10.dp)
                )
                .background(
                    color = Color.White
                )
                .weight(0.25f)
        ) {

            if (viewModel.isNested.value) {

                val materials = viewModel.flatMaterialList.value

                LazyColumn() {
                    items(
                        items = materials
                    ) { material ->
                        FlatMaterialCard(
                            flatMaterial = material, detail = Detail(
                                viewModel.detailHeight.value,
                                viewModel.detailWidth.value,
                                viewModel.detailMargin.value
                            ), viewModel.materialMargin.value
                        )
                    }
                }
            }
        }
    }
}
