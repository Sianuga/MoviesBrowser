package com.example.movieui.core.route

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.moviebrowser.ui.HomeScreen
import com.example.moviesbrowser.core.AppRouteNames
import com.example.moviesbrowser.ui.details.DetailScreen
import com.example.moviesbrowser.ui.home.data.movies


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
            composable("${AppRouteNames.Detail}/{id}") { it ->
                val id = it.arguments?.getString("id")
                val movie = movies.first { it.id == id?.toIntOrNull() }
                Log.d("AppRoute", "GenerateRoute: $movie")
                DetailScreen(navController = navController, movie)
            }
        }
    }
}