package com.example.finalsetup

import okhttp3.Route

sealed class NavRoute(val route: String) {
    object LoginUsingGoogle : NavRoute("login")
    object LogoutScreen : NavRoute("logout")
    object HomeScreen : NavRoute("home")


}