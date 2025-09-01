package com.example.composecourse.noteapp.data

import com.example.composecourse.noteapp.model.Note

class NoteDataSource {
    fun loadNotes(): List<Note> {
        return listOf(
            Note(title = "Titanic", description = "A sad love story"),
            Note(
                title = "The Matrix",
                description = "A mind-bending sci-fi thriller about reality and choice"
            ),
            Note(
                title = "Forrest Gump",
                description = "Life lessons through the eyes of an extraordinary ordinary man"
            ),
            Note(
                title = "Inception",
                description = "Dreams within dreams in a complex heist story"
            ),
            Note(
                title = "The Godfather",
                description = "Epic tale of power, family and the American mafia"
            ),
            Note(
                title = "Pulp Fiction",
                description = "Interconnected stories of crime and redemption in LA"
            ),
            Note(
                title = "The Shawshank Redemption",
                description = "Hope and friendship behind prison walls"
            ),
            Note(
                title = "Interstellar",
                description = "A father's journey through space and time to save humanity"
            ),
            Note(
                title = "Fight Club",
                description = "Dark exploration of masculinity and consumer culture"
            )
        )
    }
}