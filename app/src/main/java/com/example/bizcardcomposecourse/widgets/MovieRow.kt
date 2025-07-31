package com.example.bizcardcomposecourse.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.compose.rememberAsyncImagePainter
import com.example.bizcardcomposecourse.model.Movie
import com.example.bizcardcomposecourse.model.getMovies

@Composable
fun MovieRow(movie: Movie, onItemClicked: (String?) -> Unit) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .height(130.dp)
            .clickable {
                onItemClicked(movie.imdbID)
            },
        shape = RoundedCornerShape(corner = CornerSize(12.dp)),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Surface(
                modifier = Modifier
                    .padding(12.dp)
                    .size(100.dp),
                shape = RectangleShape,
                shadowElevation = 4.dp

            ) {
                AsyncImage(
                    model = movie.images[0],
                    contentDescription = "movie image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )
            }
            Column(Modifier.padding(4.dp)) {
                Text(
                    text = movie.title,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = "Director: ${movie.director}",
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = "Released: ${movie.year}",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MovieRowPreview() {
    val movie = getMovies().first()
    MovieRow(movie = movie) {}
}