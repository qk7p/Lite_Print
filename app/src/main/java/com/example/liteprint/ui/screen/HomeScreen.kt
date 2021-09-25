package com.example.liteprint

import DarkBlue
import LightBlue
import LightGrey
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.liteprint.ui.custom.HeaderTextField
import com.example.liteprint.ui.screen.main.BodyText
import com.example.liteprint.ui.screen.main.HeaderButton
import com.example.liteprint.ui.screen.main.HeaderText
import com.example.liteprint.ui.theme.*

@Preview
@Composable
fun RoundedCornerShape() {
    HomeScreen()
}


@Composable
fun HomeScreen() {
    Scaffold(
        topBar = { MyTopAppBar() },
        backgroundColor = LightGrey
    ) {
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
                //.shadow(2.dp)
            ) {
                Row(Modifier.padding(16.dp)) {
                    Column(
                        Modifier
                            .padding(16.dp)
                            .weight(1f)
                    ) {
                        HeaderText(text = "Ширина изделия:", 12)
                        val detailWidthState = mutableStateOf("")
                        HeaderTextField(state = detailWidthState)

                        Spacer(modifier = Modifier.height(10.dp))
                        HeaderText(text = "Вылеты изделия:", 12)
                        val detailMarginState = mutableStateOf("")
                        HeaderTextField(state = detailMarginState)

                    }
                    Column(
                        Modifier
                            .padding(16.dp)
                            .weight(1f)
                    ) {
                        HeaderText(text = "Высота изделия:", 12)
                        val detailHeightState = mutableStateOf("")
                        HeaderTextField(state = detailHeightState)

                        Spacer(modifier = Modifier.height(10.dp))
                        HeaderText(text = "Вылеты заготовки:", 12)
                        val materialMarginState = mutableStateOf("")
                        HeaderTextField(state = materialMarginState)
                    }
                }
            }
            HeaderButton()

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
                        BodyText(text = "3050х2030 мм:", fontSize = 12)
                        BodyText(text = "1525х2030 мм:", fontSize = 12)
                        BodyText(text = "1000x700 мм:", fontSize = 12)
                        BodyText(text = "2050x1250 мм:", fontSize = 12)
                    }

                    Column(
                        Modifier
                            .padding(10.dp)
                            .weight(1f)
                    ) {
                        BodyText(text = "результат", fontSize = 12)
                        BodyText(text = "результат", fontSize = 12)
                        BodyText(text = "результат", fontSize = 12)
                        BodyText(text = "результат", fontSize = 12)
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
                        BodyText(text = "3050х2030 мм:", fontSize = 12)
                        BodyText(text = "1525х2030 мм:", fontSize = 12)
                        BodyText(text = "1000x700 мм:", fontSize = 12)
                        BodyText(text = "2050x1250 мм:", fontSize = 12)
                    }

                    Column(
                        Modifier
                            .padding(10.dp)
                            .weight(1f)
                    ) {
                        BodyText(text = "результат", fontSize = 12)
                        BodyText(text = "результат", fontSize = 12)
                        BodyText(text = "результат", fontSize = 12)
                        BodyText(text = "результат", fontSize = 12)
                    }

                }
            }

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

    