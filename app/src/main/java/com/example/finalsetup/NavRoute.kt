package com.example.finalsetup
sealed class NavRoute(val route: String) {
    object LoginUsingGoogle : NavRoute("login")
    object LogoutScreen : NavRoute("logout")
    object HomeScreen : NavRoute("home")
}