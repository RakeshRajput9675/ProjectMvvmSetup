package com.example.finalsetup.navigation

import com.example.finalsetup.screen.HomeScreen
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.finalsetup.NavRoute
import com.example.finalsetup.helper.SharedPreference
import com.example.finalsetup.screen.ChatScreen
import com.example.finalsetup.screen.DetailScreen
import com.example.finalsetup.screen.LoanScreen
import com.example.finalsetup.screen.LoginUsingGoogle
import com.example.finalsetup.screen.LogoutScreen
import com.example.finalsetup.screen.MainScreen
import com.example.finalsetup.screen.ProfileScreen
import com.example.finalsetup.screen.ScaffoldExample

@RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
@Composable
fun AppNavGraph(navController: NavHostController, intent: Intent) {

    val context = navController.context
    val startDestination = if (SharedPreference.get(context).accessToken.isNotEmpty()) {
        NavRoute.LogoutScreen.route
    } else {
        NavRoute.LoginUsingGoogle.route
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
        composable(NavRoute.DetailScreen.route) {
            DetailScreen(modifier = Modifier)
        }
        composable(NavRoute.LoanScreen.route) {
            LoanScreen()
        }
        composable(
            NavRoute.LogoutScreen.route
        ) {
            LogoutScreen(navController)
        }
        composable(
            NavRoute.ProfileScreen.route
        ) {
            ProfileScreen(modifier = Modifier)
        }
        composable(NavRoute.MainScreen.route) {
            MainScreen(navController)
        }
        composable(NavRoute.ScaffoldExample.route) {
           ScaffoldExample(navController)
        }
        composable(
            NavRoute.ChatScreen.route
        ) {
            ChatScreen()
        }
    }
    LaunchedEffect(intent) {
        intent.extras?.getString("screen")?.let { screen ->
            navController.navigate(screen)
        }
    }

}

