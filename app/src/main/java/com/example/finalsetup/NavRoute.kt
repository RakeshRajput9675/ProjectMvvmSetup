package com.example.finalsetup

import okhttp3.Route

sealed class NavRoute(val route: String) {
    object LoginUsingGoogle : NavRoute("login")
    object LogoutScreen : NavRoute("logout")
    object HomeScreen : NavRoute("home")
    object ChatScreen: NavRoute("Chat")
    object DetailScreen : NavRoute("detail")
    object ProfileScreen : NavRoute("Profile")
    object LoanScreen : NavRoute("loan")
    object MainScreen : NavRoute("main")
    object ScaffoldExample: NavRoute("scaffold")
}