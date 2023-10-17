package com.example.practice_todolist.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TaskEntity(
    @PrimaryKey val id : Int,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "content") val content: String,
    @ColumnInfo(name = "background_color") val bgColor: TaskBgColor,
    @ColumnInfo(name = "is_finish") val isFinish: Boolean = false
)