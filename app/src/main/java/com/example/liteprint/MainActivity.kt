package com.example.liteprint

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.liteprint.ui.drawer.NavDrawerItem
import com.example.liteprint.ui.screen.NestingScreen
import com.example.liteprint.ui.screen.database_screen.DatabaseScreen
import com.example.liteprint.ui.screen.main_screen.MainScreen

class MainActivity : ComponentActivity() {

  private val nestingScreenViewModel: NestingScreenViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MainScreen(viewModel = nestingScreenViewModel, activity = this)
        }
    }
}

@Composable
fun Navigation(navController: NavHostController, activity: MainActivity, viewModel: NestingScreenViewModel) {
    NavHost(navController, startDestination = NavDrawerItem.Nesting.route) {
        composable(NavDrawerItem.Nesting.route) {
            NestingScreen(viewModel = viewModel, activity = activity)
        }
        composable(NavDrawerItem.Databse.route) {
            DatabaseScreen()
        }
    }
}
