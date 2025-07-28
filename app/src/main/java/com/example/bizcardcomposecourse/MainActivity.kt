package com.example.bizcardcomposecourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
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
fun MovieContent() {
    Surface(color = Color.Green) {
        Text(text = "Hello")
    }
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