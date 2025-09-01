package com.example.composecourse.noteapp.util

import androidx.room.TypeConverter
import java.util.UUID

class UUIDConverter {

    @TypeConverter
    fun fromUUID(uuid: UUID): String = uuid.toString()

    @TypeConverter
    fun toUUID(uuid: String): UUID = UUID.fromString(uuid)
}