package com.example.bizcardcomposecourse

import androidx.compose.runtime.Composable
import com.example.bizcardcomposecourse.core.ui.theme.ComposeCourseTheme

@Composable
fun ComposeCourseApp(content: @Composable () -> Unit) {
    ComposeCourseTheme {
        content()
    }
}