package com.example.bizcardcomposecourse.screens.detail

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun MovieDetailScreen(navController: NavHostController, movieData: String?) {
    Text(text = movieData.toString())
}