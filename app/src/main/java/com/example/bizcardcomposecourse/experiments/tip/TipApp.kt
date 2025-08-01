package com.example.bizcardcomposecourse.experiments.tip

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TipApp() {
    Scaffold(content = { padding ->
        TipScreen(modifier = Modifier.padding(padding))
    })
}

@Preview(showBackground = true)
@Composable
fun TipAppPreview() {
    TipApp()
}