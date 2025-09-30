package com.example.finalsetup.navigation

import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.finalsetup.NavRoute
import com.example.finalsetup.helper.SharedPreference
import com.example.finalsetup.screen.HomeScreen
import com.example.finalsetup.screen.LoginUsingGoogle
import com.example.finalsetup.screen.LogoutScreen

@RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
@Composable
fun AppNavGraph(navController: NavHostController, intent: Intent) {

    LaunchedEffect(intent) {
        intent?.extras?.getString("screen")?.let { screen ->
            if (screen == NavRoute.LogoutScreen.route) {
                navController.navigate(NavRoute.LogoutScreen.route)
            }

        }
    }
    val context = navController.context
    val startDestination = if (SharedPreference.get(context).accessToken.isNotEmpty()) {
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

