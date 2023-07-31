package com.example.whattodo.core.navigation

sealed class NavigationName(val route: String) {
    object Home:NavigationName("home_screen")
    object Detail:NavigationName("detail_screen")
}