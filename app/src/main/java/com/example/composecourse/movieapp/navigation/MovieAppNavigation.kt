package com.example.composecourse.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.composecourse.movieapp.screen.detail.MovieDetailScreen
import com.example.composecourse.movieapp.screen.home.MovieHomeScreen

@Composable
fun MovieAppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = MovieScreens.HomeScreen.name) {
        composable(
            route = MovieScreens.HomeScreen.name
        ) {
            MovieHomeScreen(navController = navController)
        }
        composable(
            route = MovieScreens.MovieDetailScreen.name + "/{movie}",
            arguments = listOf(navArgument("movie") { type = NavType.StringType })
        ) { backStackEntry ->
            MovieDetailScreen(navController = navController, backStackEntry.arguments?.getString("movie"))
        }
    }
}


