package com.example.liteprint.ui.screen.main_screen

import DarkBlue
import androidx.compose.material.DrawerValue
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.rememberNavController
import com.example.liteprint.MainActivity
import com.example.liteprint.Navigation
import com.example.liteprint.NestingScreenViewModel

import com.example.liteprint.ui.drawer.Drawer
import com.example.liteprint.ui.screen.main_screen.component.TopBar

@Composable
fun MainScreen(viewModel: NestingScreenViewModel, activity: MainActivity) {
    val scaffoldState =
        rememberScaffoldState(rememberDrawerState(initialValue = DrawerValue.Closed))
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
TopBar(scope = scope, scaffoldState = scaffoldState)
        },
        drawerBackgroundColor = DarkBlue,
        drawerContent = {
Drawer(scope = scope, scaffoldState = scaffoldState, navController = navController)
        },
    )
    {
Navigation(navController = navController, activity, viewModel )
    }
}