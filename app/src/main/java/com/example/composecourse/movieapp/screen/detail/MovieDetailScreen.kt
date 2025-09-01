package com.example.composecourse.movieapp.screen.detail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.example.composecourse.movieapp.model.Movie
import com.example.composecourse.movieapp.model.getMovies
import com.example.composecourse.movieapp.screen.home.MovieRow
import kotlin.collections.orEmpty

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieDetailScreen(navController: NavHostController, movieId: String?) {
    Scaffold(topBar = {
        TopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.White
            ), title = {
                Text(text = "Movies")
            }, navigationIcon = {
                Icon(
                    imageVector = Icons.Default.ArrowBackIosNew,
                    contentDescription = "Arrow Back",
                    modifier = Modifier.clickable {
                        navController.popBackStack()
                    })
            })
    }, content = { padding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier.padding(padding)
        ) {
            val movie = getMovieById(movieId)

            MovieRow(movie) { }
            Spacer(modifier = Modifier.height(8.dp))
            HorizontalDivider()
            Text(text = "Movie Images", style = MaterialTheme.typography.titleLarge)
            HorizontalScrollableImageView(movie)
        }
    })
}

@Composable
private fun HorizontalScrollableImageView(movie: Movie?) {
    LazyRow {
        items(movie?.images.orEmpty()) { image ->
            Card(
                modifier = Modifier
                    .padding(12.dp)
                    .width(150.dp)
                    .aspectRatio(9f / 16f),
                elevation = CardDefaults.cardElevation(5.dp)
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(image)
                        .crossfade(true)
                        .build(),
                    contentDescription = "movie image detail",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}

fun getMovieById(movieId: String?): Movie? = getMovies().find { movie -> movie.imdbID == movieId }

@Preview(showBackground = true)
@Composable
fun MovieDetailScreenPreview() {
    val navController = rememberNavController()
    MovieDetailScreen(
        navController = navController,
        movieId = "001",
    )
}


