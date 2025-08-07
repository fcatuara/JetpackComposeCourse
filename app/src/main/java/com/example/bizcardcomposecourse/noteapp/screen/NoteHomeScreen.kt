package com.example.bizcardcomposecourse.noteapp.screen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bizcardcomposecourse.R
import com.example.bizcardcomposecourse.noteapp.component.NoteButton
import com.example.bizcardcomposecourse.noteapp.component.NoteInputText
import com.example.bizcardcomposecourse.noteapp.data.NoteDataSource
import com.example.bizcardcomposecourse.noteapp.model.Note
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteHomeScreen(
    notes: List<Note>,
    onAddNote: (Note) -> Unit = {},
    onRemoveNote: (Note) -> Unit = {}
) {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column(Modifier.padding(6.dp)) {
        TopAppBar(
            modifier = Modifier.background(color = Color.LightGray),
            title = { Text(text = stringResource(id = R.string.note_app_name)) },
            actions = {
                Icon(imageVector = Icons.Rounded.Notifications, contentDescription = "app bar icon")
            })
        Column(
            Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            NoteInputText(
                text = title,
                label = "Add a title",
                onTextChange = {
                    if (isInputTextValueValid(it)) title = it
                },
                modifier = Modifier.padding(top = 9.dp, bottom = 8.dp),
            )
            NoteInputText(
                text = description, label = "Add a note", onTextChange = {
                    if (isInputTextValueValid(it)) description = it
                }, modifier = Modifier.padding(top = 9.dp, bottom = 8.dp)
            )
            NoteButton(text = "Save", onClick = {
                if (isSaveEnabled(title, description)) {
                    onAddNote(Note(title = title, description = description))
                    Toast.makeText(context, "Note added", Toast.LENGTH_SHORT).show()
                }
            })
        }
        HorizontalDivider(modifier = Modifier.padding(10.dp))
        NoteList(
            notes = notes,
            onNoteClicked = {
                onRemoveNote(it)
            })
    }
}

@Composable
fun NoteList(notes: List<Note>, onNoteClicked: (Note) -> Unit) {
    LazyColumn {
        items(notes) { note ->
            NoteRow(note) { noteClicked ->
                onNoteClicked(noteClicked)
            }
        }
    }
}

@Composable
fun NoteRow(
    note: Note,
    modifier: Modifier = Modifier,
    onNoteClicked: (Note) -> Unit = {}
) {
    Surface(
        modifier = modifier
            .padding(4.dp)
            .clip(RoundedCornerShape(topEnd = 33.dp, bottomStart = 33.dp))
            .fillMaxWidth(),
        color = Color(0xFFDFE6EB),
        shadowElevation = 6.dp
    ) {
        Column(
            modifier = modifier
                .clickable { onNoteClicked(note) }
                .padding(horizontal = 14.dp, vertical = 6.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(text = note.title, style = MaterialTheme.typography.bodyLarge)
            Text(text = note.description, style = MaterialTheme.typography.bodyMedium)
            Text(
                text = formatDate(note.entryDate),
                style = MaterialTheme.typography.labelMedium
            )
        }
    }
}

private fun isInputTextValueValid(value: String) = value.all { char ->
    char.isLetter() || char.isWhitespace()
}

private fun isSaveEnabled(vararg fields: String) = fields.all { it.isNotEmpty() }

private fun formatDate(date: Date): String {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    return date.toInstant()
        .atZone(ZoneId.systemDefault())
        .format(formatter)
}


@Preview(showBackground = true)
@Composable
fun NoteHomeScreenPreview() {
    NoteHomeScreen(notes = NoteDataSource().loadNotes())
}
