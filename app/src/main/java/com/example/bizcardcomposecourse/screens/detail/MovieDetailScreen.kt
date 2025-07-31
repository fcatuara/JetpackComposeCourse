package com.example.bizcardcomposecourse.screens.detail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieDetailScreen(navController: NavHostController, movieData: String?) {
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
        Box(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(padding),
            contentAlignment = Alignment.Center
        ) {
            Text(text = movieData.toString(), style = MaterialTheme.typography.titleLarge)
        }
    })
}

@Preview(showBackground = true)
@Composable
fun MovieDetailScreenPreview() {
    val navController = rememberNavController()
    MovieDetailScreen(
        navController = navController,
        movieData = "Il Signore degli Anelli (2001)"
    )
}


