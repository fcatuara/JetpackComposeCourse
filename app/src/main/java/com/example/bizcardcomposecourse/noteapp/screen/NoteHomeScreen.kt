package com.example.bizcardcomposecourse.noteapp.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bizcardcomposecourse.R
import com.example.bizcardcomposecourse.noteapp.component.NoteInputText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteHomeScreen() {
    Column(Modifier.padding(6.dp)) {
        TopAppBar(
            modifier = Modifier.background(color = Color.LightGray),
            title = { Text(text = stringResource(id = R.string.note_app_name)) },
            actions = {
                Icon(imageVector = Icons.Rounded.Notifications, contentDescription = "app bar icon")
            }
        )
        Column(
            Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NoteInputText(text = "Hello", label = "Hello", onTextChange = {})
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NoteHomeScreenPreview() {
    NoteHomeScreen()
}
