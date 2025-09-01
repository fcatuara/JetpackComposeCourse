package com.example.composecourse.experiments.dollarCounter

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun DollarCounterApp() {
    Scaffold(content = { padding ->
        DollarCounterScreen(modifier = Modifier.padding(padding))
    })
}

@Preview(showBackground = true)
@Composable
fun DollarCounterAppPreview() {
    DollarCounterApp()
}