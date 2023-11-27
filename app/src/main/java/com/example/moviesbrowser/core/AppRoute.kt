package com.example.movieui.core.route

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.moviebrowser.ui.HomeScreen
import com.example.moviesbrowser.core.AppRouteNames


object AppRoute {

    @Composable
    fun GenerateRoute(navController: NavHostController) {
        NavHost(
            navController = navController,
            startDestination = AppRouteNames.Home,
        ) {
            composable(AppRouteNames.Home) {
                HomeScreen(navController = navController)
            }
        }
    }
}