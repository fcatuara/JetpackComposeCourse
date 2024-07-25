package com.example.bizcardcomposecourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.bizcardcomposecourse.ui.theme.BizCardComposeCourseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BizCardComposeCourseTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    Scaffold(content = { padding ->
        BizCardScreen(modifier = Modifier.padding(padding))
    })
}

@Preview(showBackground = true)
@Composable
fun MyAppPreview() {
    MyApp()
}