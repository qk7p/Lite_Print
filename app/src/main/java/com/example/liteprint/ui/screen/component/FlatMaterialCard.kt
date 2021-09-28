package com.example.liteprint.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.unit.dp
import com.example.liteprint.model.Detail
import com.example.liteprint.model.FlatMaterial
import com.example.liteprint.ui.screen.main.BodyText
import com.example.liteprint.util.FlatNester


@Composable
fun FlatMaterialCard(
    flatMaterial: FlatMaterial,
    detail: Detail,
    materialMargin: Int
) {
    flatMaterial.changeMaterialMargin(materialMargin)
    val nester = FlatNester(detail, flatMaterial)
    val isSelected = false

    if (isSelected) {

    }

    Row() {
        Column(
            Modifier
                .padding(2.dp)
                .weight(0.33f), horizontalAlignment = Alignment.Start
        ) {
            BodyText(text = flatMaterial.getMaterial(), fontSize = 12)
        }

        Spacer(modifier = Modifier.width(10.dp))

        Column(
            Modifier
                .padding(2.dp)
                .weight(0.66f) , horizontalAlignment = Alignment.Start
        ) {
            Row() {
                val text = "на заготовке: " + nester.nest().toString() + " шт."
                BodyText(text = text, fontSize = 12)
            }
            Row() {

                val materialArea = String.format("%.3f",(flatMaterial._width.toDouble() * flatMaterial._height.toDouble())/1000000 )

                BodyText(
                    text = "площадь заготовки: $materialArea м2",
                    fontSize = 12
                )
            }
        }
    }
}
