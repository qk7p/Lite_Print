package com.example.liteprint.ui.screen.nesting_screen.component

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.liteprint.model.Detail
import com.example.liteprint.model.ScrollMaterial
import com.example.liteprint.ui.screen.main.BodyText
import com.example.liteprint.util.ScrollNester

@Composable
fun ScrollMaterialCard(
    scrollMaterial: ScrollMaterial,
    detail: Detail
) {
    val nester = ScrollNester(detail, scrollMaterial)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth(1f)
            .padding(4.dp)
    ) {
        Row() {

            val (quantity, usedLength) = nester.simpleNest()

            Column(modifier = Modifier.weight(0.4f)) {
                BodyText(text = scrollMaterial.getScrollMaterial(), fontSize = 12)
                Row() {
                    BodyText(text = "погонаж:", fontSize = 12)
                    Spacer(modifier = Modifier.width(4.dp))
                    BodyText(text = "$usedLength п.м.", fontSize = 12)
                }
            }
            Column(modifier = Modifier.weight(0.6f)) {
                Row() {
                    Row() {
                        val usedMaterialArea = detail.detailArea * quantity
                        val materialArea = (scrollMaterial.width.toDouble() / 1000) * usedLength
                        val efficiency =
                            String.format("%.2f", (usedMaterialArea / materialArea * 100))

                        BodyText(text = "количество:", fontSize = 12)
                        Spacer(modifier = Modifier.width(4.dp))
                        BodyText(text = "$quantity шт.", fontSize = 12)
                        Spacer(modifier = Modifier.width(4.dp))
                        BodyText(text = "$efficiency%", fontSize = 12)
                    }
                }
                Row() {
                    BodyText(text = "площадь печати:", fontSize = 12)
                    Spacer(modifier = Modifier.width(4.dp))
                    val materialArea =
                        String.format("%.3f", (usedLength * scrollMaterial.width) / 1000)
                    BodyText(text = "$materialArea п.м.", fontSize = 12)
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewCard() {
    ScrollMaterialCard(scrollMaterial = ScrollMaterial(1000), detail = Detail(100, 100, 10))
}
