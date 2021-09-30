package com.example.liteprint.ui.screen.nesting_screen.component

import DarkBlue
import DarkCarrot
import LightBlue
import LightCarrot
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.liteprint.NestingScreenViewModel
import com.example.liteprint.model.FlatMaterial
import com.example.liteprint.ui.custom.GradientButton
import com.example.liteprint.ui.custom.HeaderTextField
import com.example.liteprint.ui.screen.main.BodyText
import com.example.liteprint.ui.screen.main.HeaderText

@Composable
fun AddMaterialDialog(viewModel: NestingScreenViewModel) {

    if (viewModel.isDialogShow.value) {

        Dialog(
            onDismissRequest = {
                viewModel.closeDialog()
            }, properties = DialogProperties(),
            content = {
                Column() {
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
                            modifier = Modifier
                                .fillMaxWidth(1f)
                                .padding(5.dp)
                        ) {
                            HeaderText(text = "добавить новый размер", fontSize = 14)
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
                    ) {
                        Column(
                            Modifier
                                .padding(16.dp)
                        ) {
                            BodyText(text = "Ширина:", 12)
                            val newMaterialWidth = viewModel.getNewMaterialWidthString()
                            HeaderTextField(newMaterialWidth, viewModel::setNewMaterialWidth)

                            Spacer(modifier = Modifier.height(10.dp))

                            BodyText(text = "Высота:", 12)
                            val newMaterialHeight = viewModel.getNewMaterialHeightString()
                            HeaderTextField(
                                text = newMaterialHeight,
                                viewModel::setNewMaterialHeight
                            )

                            Spacer(modifier = Modifier.height(10.dp))
                            Row(
                                Modifier
                                    .fillMaxWidth(1f)
                                    .height(30.dp)
                                    .padding(5.dp)
                            ) {
                                Column(modifier = Modifier.weight(1f)) {
                                    Box(contentAlignment = Alignment.Center) {
                                        GradientButton(
                                            gradient = Brush.horizontalGradient(
                                                colors = listOf(
                                                    DarkCarrot,
                                                    LightCarrot
                                                )
                                            ),
                                            {
                                                viewModel.closeDialog()
                                            },
                                            shape = RoundedCornerShape(5.dp, 0.dp, 0.dp, 5.dp)
                                        )
                                        HeaderText(text = "отмена", fontSize = 12)
                                    }
                                }
                                Column(modifier = Modifier.weight(1f)) {
                                    Box(contentAlignment = Alignment.Center) {
                                        GradientButton(
                                            gradient = Brush.horizontalGradient(
                                                colors = listOf(
                                                    LightCarrot,
                                                    DarkCarrot
                                                )
                                            ),
                                            {
                                                viewModel.flatMaterialArrayList.add(
                                                    FlatMaterial(
                                                        viewModel.newMaterialWidth.value,
                                                        viewModel.newMaterialHeight.value,
                                                        viewModel.materialMargin.value
                                                    )
                                                )

                                                viewModel.setNewMaterialWidth("0")
                                                viewModel.setNewMaterialHeight("0")

                                                viewModel.isNested.value = false
                                                viewModel.isNested.value = true

                                                viewModel.closeDialog()
                                            },
                                            shape = RoundedCornerShape(0.dp, 5.dp, 5.dp, 0.dp)
                                        )
                                        HeaderText(text = "добавить", fontSize = 12)
                                    }
                                }
                            }
                        }
                    }
                }
            }
        )
    }
}


@Preview
@Composable
fun DialogPreview() {
    AddMaterialDialog(viewModel = NestingScreenViewModel())
}