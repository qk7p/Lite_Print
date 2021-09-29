package com.example.liteprint

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.liteprint.ui.screen.NestingScreen

class MainActivity : ComponentActivity() {

  private val nestingScreenViewModel: NestingScreenViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            NestingScreen(nestingScreenViewModel, this)
        }
    }

}
