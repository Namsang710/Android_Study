package com.example.practice_todolist.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.practice_todolist.entity.TaskEntity


@Dao
interface TaskDAO {

    @Query("SELECT * FROM taskentity ")
    fun getTask() : List<TaskEntity>

    @Insert
    fun insertTask(task : TaskEntity)

    @Delete
    fun deleteTask(task: TaskEntity)

    @Update
    fun updateTask(task : TaskEntity)
}