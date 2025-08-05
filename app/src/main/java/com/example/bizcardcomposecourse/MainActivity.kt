package com.example.bizcardcomposecourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bizcardcomposecourse.noteapp.model.Note
import com.example.bizcardcomposecourse.noteapp.screen.NoteHomeScreen
import com.example.bizcardcomposecourse.noteapp.screen.NoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        WindowCompat.setDecorFitsSystemWindows(window, true)
        setContent {
            ComposeCourseApp {
                val noteViewModel: NoteViewModel by viewModels()
                NotesApp(viewModel = noteViewModel)
            }
        }
    }

@Composable
fun NotesApp(viewModel: NoteViewModel = viewModel()) {
    val noteList = viewModel.getAllNotes()
    NoteHomeScreen(
        notes = noteList,
        onAddNote = { viewModel.addNote(it) },
        onRemoveNote = { viewModel.removeNote(it) }
    )
}


@Preview(showBackground = true)
@Composable
fun MainActivityPreview() {
    ComposeCourseApp {
        val sampleNotes = remember {
            mutableStateListOf(
                Note(title = "Meeting Notes", description = "Important project discussion"),
                Note(title = "Shopping List", description = "Milk, bread, eggs, coffee"),
                Note(title = "Book Ideas", description = "Sci-fi novel about time travel")
            )
        }

        NoteHomeScreen(
            notes = sampleNotes,
            onAddNote = { sampleNotes.add(it) },
            onRemoveNote = { sampleNotes.remove(it) }
        )
    }
}
}





