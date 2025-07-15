package com.example.questionbank

data class Answer(
    val text: String,
    var likes: Int = 0,
    var dislikes: Int = 0
)

data class Question(
    val text: String,
    val answers: MutableList<Answer> = mutableListOf()
)

data class Topic(
    val name: String,
    val questions: MutableList<Question> = mutableListOf()
)
