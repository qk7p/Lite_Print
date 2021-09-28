package com.example.liteprint.ui.screen

import DarkBlue
import LightBlue
import LightGrey
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.liteprint.HomeScreenViewModel
import com.example.liteprint.MainActivity
import com.example.liteprint.model.Detail
import com.example.liteprint.ui.screen.component.ScrollMaterialCard
import com.example.liteprint.ui.custom.HeaderTextField
import com.example.liteprint.ui.screen.component.SendButton
import com.example.liteprint.ui.screen.main.BodyText
import com.example.liteprint.ui.screen.main.HeaderButton
import com.example.liteprint.ui.screen.main.HeaderText
import com.example.liteprint.ui.theme.RussoOne

@Preview
@Composable
fun RoundedCornerShape() {
    HomeScreen(viewModel = HomeScreenViewModel(), activity = MainActivity())
}


@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel,
    activity: MainActivity
) {
    Scaffold(
        topBar = { MyTopAppBar() },
        backgroundColor = LightGrey
    ) {

        val isNested = viewModel.isNested.value

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
                .padding(16.dp)
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
                Row(Modifier.padding(16.dp)) {
                    Column(
                        Modifier
                            .padding(16.dp)
                            .weight(1f)
                    ) {
                        HeaderText(text = "Ширина изделия:", 12)
                        val detailWidth = viewModel.detailWidth.value
                        HeaderTextField(detailWidth, viewModel::onDetailWidthChanged)

                        Spacer(modifier = Modifier.height(10.dp))

                        HeaderText(text = "Вылеты изделия:", 12)
                        val detailMarginState = viewModel.detailMargin.value
                        HeaderTextField(text = detailMarginState, viewModel::onDetailMarginChanged)

                    }
                    Column(
                        Modifier
                            .padding(16.dp)
                            .weight(1f)
                    ) {
                        HeaderText(text = "Высота изделия:", 12)
                        val detailHeight = viewModel.detailHeight.value
                        HeaderTextField(text = detailHeight, viewModel::onDetailHeightChanged)

                        Spacer(modifier = Modifier.height(10.dp))

                        HeaderText(text = "Вылеты заготовки:", 12)
                        val materialMargin = viewModel.materialMargin.value
                        HeaderTextField(text = materialMargin, viewModel::onMaterialMarginChanged)
                    }
                }
            }
            HeaderButton(viewModel = viewModel)

            Spacer(modifier = Modifier.height(10.dp))

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
                Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth(1f)) {
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
                Row(
                    Modifier
                        .padding(5.dp)
                        .align(Alignment.Center)
                        .fillMaxWidth(1f)
                )
                {
                    if (isNested) {
                        Column(
                            Modifier
                                .padding(5.dp)
                                .weight(0.25f)
                        ) {


                            val materials = viewModel.flatMaterialList.value

                            LazyColumn {
                                items(
                                    items = materials
                                ) { material ->
                                    FlatMaterialCard(
                                        flatMaterial = material, detail = Detail(
                                            viewModel.detailHeight.value.toInt(),
                                            viewModel.detailWidth.value.toInt(),
                                            viewModel.detailMargin.value.toInt()
                                        ), viewModel.materialMargin.value.toInt()
                                    )
                                }
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))


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
                Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth(1f)) {
                    HeaderText(text = "на рулоне", fontSize = 14)
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
                Row(
                    Modifier
                        .padding(5.dp)
                        .align(Alignment.Center)
                        .fillMaxWidth(1f)
                )
                {
                    if (isNested) {

                        Column(
                            Modifier
                                .padding(5.dp)
                                .weight(1f)
                        ) {


                            val materials = viewModel.scrollMaterialList.value

                            LazyColumn {
                                items(
                                    items = materials
                                ) { material ->
                                    ScrollMaterialCard(
                                        scrollMaterial = material, detail = Detail(
                                            viewModel.detailHeight.value.toInt(),
                                            viewModel.detailWidth.value.toInt(),
                                            viewModel.detailMargin.value.toInt()
                                        )
                                    )
                                }
                            }
                        }

                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(
                        shape = RoundedCornerShape(10.dp)
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
                        if (isNested) {
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
                        if (isNested) {
                            val detailPerimeter = viewModel.detailPerimeter.value
                            BodyText(text = "$detailPerimeter п.м.", fontSize = 12)
                        }
                    }

                }
            }
            Spacer(Modifier.height(10.dp))

            SendButton(viewModel = viewModel, activity = activity)

        }
    }
}


@Composable
fun MyTopAppBar() {
    TopAppBar(
        title = {
            Text(
                text = "LightPrint",
                fontFamily = RussoOne,
                color = Color.Black,
                fontSize = 18.sp

            )
        },
        backgroundColor = Color.White
    )
}



    