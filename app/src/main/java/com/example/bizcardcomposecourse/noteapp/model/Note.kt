package com.example.bizcardcomposecourse.noteapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant
import java.time.LocalDateTime
import java.util.Date
import java.util.UUID
import kotlin.time.ExperimentalTime

/**
 * @property id Unique identifier for the note. Automatically generated using UUID.randomUUID()
 *              if not specified during creation.
 * @property entryDate Creation timestamp of the note. Automatically set to the current date and time
 *                     using LocalDateTime.now() if not provided.
 */
@Entity(tableName = "notes_tbl")
@OptIn(ExperimentalTime::class)
data class Note(
    @PrimaryKey
    val id: UUID = UUID.randomUUID(),
    @ColumnInfo(name = "note_title")
    val title: String,
    @ColumnInfo(name = "note_description")
    val description: String,
    @ColumnInfo(name = "note_entry_date")
    val entryDate: Date = Date.from(Instant.now())
)
