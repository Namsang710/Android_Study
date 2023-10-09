package com.example.practice_todolist.entity

data class Task(
    val id: Int,
    val title: String,
    val content: String,
    val bgColor: TaskBgColor,
    val isFinish: Boolean = false
)