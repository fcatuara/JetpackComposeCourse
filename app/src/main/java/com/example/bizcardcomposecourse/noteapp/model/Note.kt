package com.example.bizcardcomposecourse.noteapp.model

import java.time.LocalDateTime
import java.util.UUID

/**
 * @property id Unique identifier for the note. Automatically generated using UUID.randomUUID()
 *              if not specified during creation.
 * @property entryDate Creation timestamp of the note. Automatically set to the current date and time
 *                     using LocalDateTime.now() if not provided.
 */
data class Note(
    val id: UUID = UUID.randomUUID(),
    val title: String,
    val description: String,
    val entryDate: LocalDateTime = LocalDateTime.now()
)
