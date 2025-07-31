package com.example.bizcardcomposecourse.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import coil3.compose.rememberAsyncImagePainter
import coil3.request.ImageRequest
import coil3.request.colorSpace
import coil3.request.crossfade
import com.example.bizcardcomposecourse.model.Movie
import com.example.bizcardcomposecourse.model.getMovies

@Composable
fun MovieRow(movie: Movie, onItemClicked: (String?) -> Unit) {

    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .clickable {
                onItemClicked(movie.imdbID)
            },
        shape = RoundedCornerShape(corner = CornerSize(12.dp)),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Surface(
                modifier = Modifier
                    .padding(12.dp)
                    .width(100.dp),
                shape = RectangleShape,
                shadowElevation = 4.dp,
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(movie.images[0])
                        .crossfade(true)
                        .build(),
                    contentDescription = "movie image",
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
                AnimatedVisibility(visible = expanded) {
                    Column {
                        Text(
                            buildAnnotatedString {
                                withStyle(
                                    style = SpanStyle(
                                        color = Color.DarkGray,
                                        fontSize = 13.sp
                                    )
                                ) {
                                    append("Plot: ")
                                }
                                withStyle(
                                    style = SpanStyle(
                                        color = Color.DarkGray,
                                        fontSize = 13.sp,
                                        fontWeight = FontWeight.Light,
                                    )
                                ) {
                                    append(movie.plot.toString())
                                }
                            },
                            modifier = Modifier.padding(6.dp),
                            lineHeight = 16.sp
                        )

                        HorizontalDivider(modifier = Modifier.padding(2.dp))

                        Text(
                            text = "Actors: ${movie.actors}",
                            style = MaterialTheme.typography.bodySmall
                        )
                        Text(
                            text = "Rating: ${movie.imdbRating}",
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }

                val arrowIcon =
                    if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown
                Icon(
                    imageVector = arrowIcon,
                    contentDescription = "arrow down",
                    modifier = Modifier
                        .size(25.dp)
                        .clickable {
                            expanded = !expanded
                        },
                    tint = Color.DarkGray
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