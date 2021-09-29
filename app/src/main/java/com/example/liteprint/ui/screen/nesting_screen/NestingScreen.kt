package com.example.liteprint.ui.screen

import DarkBlue
import LightBlue
import LightGrey
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.liteprint.NestingScreenViewModel
import com.example.liteprint.MainActivity
import com.example.liteprint.model.Detail
import com.example.liteprint.ui.custom.HeaderTextField
import com.example.liteprint.ui.screen.main.BodyText
import com.example.liteprint.ui.screen.main.HeaderText
import com.example.liteprint.ui.screen.nesting_screen.component.*
import com.example.liteprint.ui.theme.RussoOne

@Preview
@Composable
fun RoundedCornerShape() {
    NestingScreen(viewModel = NestingScreenViewModel(), activity = MainActivity())
}


@Composable
fun NestingScreen(
    viewModel: NestingScreenViewModel,
    activity: MainActivity
) {
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
            NestingHeader(viewModel = viewModel)

            Spacer(modifier = Modifier.height(10.dp))



            FlatMaterialNestingList(viewModel =viewModel)

            Spacer(modifier = Modifier.height(10.dp))

            ScrollMaterialNestingList(viewModel = viewModel)

            Spacer(modifier = Modifier.height(10.dp))

            NestingFooter(viewModel = viewModel, activity = activity)

        }
    }
}


@Composable
fun MyTopAppBar() {
    TopAppBar(
        title = {
            Text(
                text = "Lite Print",
                fontFamily = RussoOne,
                color = Color.Black,
                fontSize = 18.sp

            )
        },
        backgroundColor = Color.White
    )
}



    