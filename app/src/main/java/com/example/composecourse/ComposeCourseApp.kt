package com.example.composecourse

import androidx.compose.runtime.Composable
import com.example.composecourse.core.ui.theme.ComposeCourseTheme

@Composable
fun ComposeCourseApp(content: @Composable () -> Unit) {
    ComposeCourseTheme {
        content()
    }
}