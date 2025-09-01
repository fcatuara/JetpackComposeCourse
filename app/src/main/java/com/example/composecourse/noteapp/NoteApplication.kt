package com.example.composecourse.noteapp

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.qualifiers.ApplicationContext
import jakarta.inject.Inject

@HiltAndroidApp
class NoteApplication : Application() {

    @Inject
    @ApplicationContext
    lateinit var context: Context
}