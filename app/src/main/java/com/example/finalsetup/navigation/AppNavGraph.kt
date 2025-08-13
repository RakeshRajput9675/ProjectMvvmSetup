package com.example.finalsetup.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.finalsetup.helper.SharedPreference
import com.example.finalsetup.screen.HomeScreen
import com.example.finalsetup.screen.MainScreen

@Composable
fun AppNavGraph(navController: NavHostController) {
    val context = navController.context
    val startDestination = if (!SharedPreference.get(context).accessToken.isNullOrEmpty()) {
        "home"
    } else {
        "main"
    }

    NavHost(navController = navController, startDestination = startDestination) {
        composable("main") {
            MainScreen(navController)
        }
        composable("home") {
            HomeScreen()
        }
    }

}

