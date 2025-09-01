package com.example.composecourse.jettriviaapp.model

data class QuestionItem(
    val answer: String? = null,
    val category: String? = null,
    val choices: List<String>? = null,
    val question: String? = null
)