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
                .weight(0.33f), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BodyText(text = flatMaterial.getMaterial(), fontSize = 12)
        }

        Spacer(modifier = Modifier.width(10.dp))

        Column(
            Modifier
                .padding(2.dp)
                .weight(0.66f) , horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row() {
                val text = "на заготовке: " + nester.nest().toString() + " шт."
                BodyText(text = text, fontSize = 12)
            }
            Row() {

                BodyText(
                    text = "площадь заготовки: ${flatMaterial.getMaterialAreaString()} м2",
                    fontSize = 12
                )
            }
        }
    }
}
