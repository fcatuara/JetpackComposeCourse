package com.example.bizcardcomposecourse

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.bizcardcomposecourse.ui.theme.ComposeCourseTheme

@Composable
fun ComposeCourseApp(content: @Composable () -> Unit) {
    ComposeCourseTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            content()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieApp(content: @Composable () -> Unit) {
    ComposeCourseTheme {
        //content()
        Scaffold(
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.Magenta
                    ),
                    title = {
                        Text(text = "Movies")
                    },
                )
            }, content = { padding ->
                Box(modifier = Modifier.padding(padding)) {
                    content()
                }
            })
    }
}