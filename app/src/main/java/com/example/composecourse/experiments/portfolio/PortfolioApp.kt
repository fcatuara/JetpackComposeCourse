package com.example.composecourse.experiments.portfolio

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun PortfolioApp() {
    Scaffold(content = { padding ->
        PortfolioScreen(modifier = Modifier.padding(padding))
    })
}

@Preview(showBackground = true)
@Composable
fun PortfolioAppPreview() {
    PortfolioApp()
}