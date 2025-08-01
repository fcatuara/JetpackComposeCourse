package com.example.bizcardcomposecourse.movieapp.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bizcardcomposecourse.movieapp.model.Movie
import com.example.bizcardcomposecourse.movieapp.model.getMovies
import com.example.bizcardcomposecourse.movieapp.navigation.MovieScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieHomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White
                ),
                title = {
                    Text(text = "Movies")
                },
            )
        }, content = { padding ->
            Box(modifier = Modifier.padding(padding)) {
                MovieContent(navController)
            }
        })
}

@Composable
fun MovieContent(
    navController: NavController,
    movieList: List<Movie> = getMovies()
) {
    Column(modifier = Modifier.padding(12.dp)) {
        LazyColumn {
            items(items = movieList) {
                MovieRow(movie = it) { movieId ->
                    val movieIdRoute = MovieScreens.MovieDetailScreen.name + "/$movieId"
                    println(movieIdRoute)
                    navController.navigate(route = movieIdRoute)
                }
            }
        }
    }
}



