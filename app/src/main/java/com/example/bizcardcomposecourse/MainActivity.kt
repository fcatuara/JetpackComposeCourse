package com.example.bizcardcomposecourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bizcardcomposecourse.routes.DollarCounterScreen
import com.example.bizcardcomposecourse.routes.PortfolioScreen
import com.example.bizcardcomposecourse.routes.TipScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //ComposeCourseApp {
            //PortfolioApp()
            //TipApp()
            //DollarCounterApp()
            //}
            MovieApp {
                MovieContent()
            }
        }
    }
}

@Composable
fun MovieContent(
    movieList: List<String> = listOf(
        "Avatar",
        "300",
        "Harry Potter",
        "Cast Away",
        "Interstellar",
        "Coco",
        "The Avengers",
        "The Dark Knight",
        "Happiness",
        "Life"
    )
) {
    Column(modifier = Modifier.padding(12.dp)) {
        LazyColumn {
            items(items = movieList) {
                MovieRow(movie = it)
            }
        }
    }
}

@Composable
fun MovieRow(movie: String) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .height(130.dp),
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
                Icon(imageVector = Icons.Default.AccountBox, contentDescription = "Movie Image")

            }
            Text(text = movie)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MovieRowPreview() {
    MovieRow(movie = "The Matrix")
}

@Composable
fun TipApp() {
    Scaffold(content = { padding ->
        TipScreen(modifier = Modifier.padding(padding))
    })
}

//@Preview(showBackground = true)
@Composable
fun TipAppPreview() {
    TipApp()
}

@Composable
fun PortfolioApp() {
    Scaffold(content = { padding ->
        PortfolioScreen(modifier = Modifier.padding(padding))
    })
}

//@Preview(showBackground = true)
@Composable
fun PortfolioAppPreview() {
    PortfolioApp()
}

@Composable
fun DollarCounterApp() {
    Scaffold(content = { padding ->
        DollarCounterScreen(modifier = Modifier.padding(padding))
    })
}

//@Preview(showBackground = true)
@Composable
fun DollarCounterAppPreview() {
    DollarCounterApp()
}

@Preview(showBackground = true)
@Composable
fun MovieAppPreview() {
    MovieApp {
        MovieContent()
    }
}