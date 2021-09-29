package com.example.liteprint.ui.custom

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.ImageBitmap

enum class MultiFabState {
    COLLAPSED, EXPANDED
}

@Composable
fun MultiFloatingActionButton(
    fabIcon: ImageBitmap,
    toState: MultiFabState
) {

}