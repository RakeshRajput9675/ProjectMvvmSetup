package com.example.finalsetup.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.finalsetup.NavRoute
import com.example.finalsetup.helper.SharedPreference
import com.example.finalsetup.screen.HomeScreen
import com.example.finalsetup.screen.LoginUsingGoogle
import com.example.finalsetup.screen.LogoutScreen
import com.example.finalsetup.screen.MainScreen

@RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
@Composable
fun AppNavGraph(navController: NavHostController) {
    val context = navController.context
    val startDestination = if (!SharedPreference.get(context).accessToken.isNullOrEmpty()) {
        NavRoute.LoginUsingGoogle.route
    } else {
        NavRoute.LogoutScreen.route
    }

    NavHost(navController = navController, startDestination = startDestination) {
        composable(
            NavRoute.LoginUsingGoogle.route
        ) {
            LoginUsingGoogle(navController)
        }
        composable(NavRoute.HomeScreen.route) {
            HomeScreen()
        }
        composable(
            NavRoute.LogoutScreen.route
        ) {
            LogoutScreen(navController)
        }
    }

}

