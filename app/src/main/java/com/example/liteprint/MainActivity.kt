package com.example.liteprint

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.liteprint.ui.screen.HomeScreen

class MainActivity : ComponentActivity() {

  private val homeScreenViewModel: HomeScreenViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            HomeScreen(homeScreenViewModel, this)
        }
    }

}
