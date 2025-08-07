package com.example.bizcardcomposecourse.noteapp.util

import androidx.room.TypeConverter
import java.util.Date

class DateConverter {

    @TypeConverter
    fun fromDate(date: Date): Long = date.time

    @TypeConverter
    fun toDate(millis: Long): Date = Date(millis)
}
