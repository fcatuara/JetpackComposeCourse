package com.example.bizcardcomposecourse

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import com.example.bizcardcomposecourse.ui.theme.ComposeCourseTheme

@Composable
fun ComposeCourseApp(content: @Composable () -> Unit) {
    ComposeCourseTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            content()
        }
    }
}