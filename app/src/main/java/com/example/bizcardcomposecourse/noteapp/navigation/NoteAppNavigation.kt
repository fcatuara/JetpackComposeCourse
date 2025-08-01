package com.example.bizcardcomposecourse.noteapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bizcardcomposecourse.movieapp.navigation.MovieScreens
import com.example.bizcardcomposecourse.movieapp.screens.home.MovieHomeScreen

@Composable
fun NoteAppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NoteScreens.NoteHomeScreen.name) {
        composable(
            route = NoteScreens.NoteHomeScreen.name
        ) {
            MovieHomeScreen(navController = navController)
        }
    }
}