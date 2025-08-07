package com.example.bizcardcomposecourse.noteapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.bizcardcomposecourse.noteapp.model.Note
import com.example.bizcardcomposecourse.noteapp.util.DateConverter
import com.example.bizcardcomposecourse.noteapp.util.UUIDConverter

@Database(entities = [Note::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class, UUIDConverter::class)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun noteDao(): NoteDatabaseDao
}
