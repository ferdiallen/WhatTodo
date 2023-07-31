package com.example.whattodo.core.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.whattodo.core.spacing
import com.example.whattodo.presentation.detail.DetailScreen
import com.example.whattodo.presentation.home.HomeScreen

@Composable
fun Navigation(
    controller: NavHostController = rememberNavController()
) {
    NavHost(navController = controller, startDestination = NavigationName.Home.route) {
        composable(NavigationName.Home.route, enterTransition = {
            fadeIn(tween(400))
        }, exitTransition = {
            fadeOut(tween(400))
        }) {
            HomeScreen(
                onGoToDetailTask = {
                    controller.popBackStack()
                },
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp)
                    .padding(top = 20.dp),
                onCreateNewTask = {
                    controller.navigate(NavigationName.Detail.route){
                        launchSingleTop = true
                    }
                }
            )
        }
        composable(NavigationName.Detail.route, enterTransition = {
            slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Left, tween(400))
        }, exitTransition = {
            slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Right, tween(400))
        }) {
            DetailScreen(
                backPress = {},
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 16.dp)
                    .padding(
                        horizontal = MaterialTheme.spacing.largeSpacing
                    )
            )
        }
    }
}