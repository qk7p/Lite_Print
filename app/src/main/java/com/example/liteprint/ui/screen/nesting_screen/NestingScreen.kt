package com.example.liteprint.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.liteprint.MainActivity
import com.example.liteprint.NestingScreenViewModel
import com.example.liteprint.ui.screen.nesting_screen.component.FlatMaterialNestingList
import com.example.liteprint.ui.screen.nesting_screen.component.NestingFooter
import com.example.liteprint.ui.screen.nesting_screen.component.NestingHeader
import com.example.liteprint.ui.screen.nesting_screen.component.ScrollMaterialNestingList

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

    Column() {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
                .padding(16.dp)

        ) {
            NestingHeader(viewModel = viewModel)

            Spacer(modifier = Modifier.height(10.dp))
            Column(modifier = Modifier.weight(0.6f)) {
                val nestingState = viewModel.nestingState.value
                when (nestingState) {
                    NestingScreenViewModel.NestingType.FlatMaterialNest -> FlatMaterialNestingList(
                        viewModel = viewModel
                    )
                    NestingScreenViewModel.NestingType.ScrollMaterialNest -> ScrollMaterialNestingList(
                        viewModel = viewModel
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            NestingFooter(viewModel = viewModel, activity = activity)

        }
    }
}





    