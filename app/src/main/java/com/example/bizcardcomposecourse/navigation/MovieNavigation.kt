package com.example.bizcardcomposecourse.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.bizcardcomposecourse.screens.detail.MovieDetailScreen
import com.example.bizcardcomposecourse.screens.home.HomeScreen

@Composable
fun MovieNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = MovieScreens.HomeScreen.name) {
        composable(
            route = MovieScreens.HomeScreen.name
        ) {
            HomeScreen(navController = navController)
        }
        composable(
            route = MovieScreens.MovieDetailScreen.name + "/{movie}",
            arguments = listOf(navArgument("movie") { type = NavType.StringType })
        ) { backStackEntry ->
            MovieDetailScreen(navController = navController, backStackEntry.arguments?.getString("movie"))
        }
    }
}


