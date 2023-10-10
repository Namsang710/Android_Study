package com.example.practice_todolist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.practice_todolist.entity.Task
import com.example.practice_todolist.entity.TaskBgColor

class TaskViewModel : ViewModel() {

    private val taskList = mutableListOf<Task>()
    private var generatedId = 0

    private var deleteCnt = 0
    private var finishCnt = 0

    private val _taskLiveData = MutableLiveData<List<Task>>()
    val taskLiveData : LiveData<List<Task>>
        get() = _taskLiveData

    init {
        _taskLiveData.value = taskList.toList()
    }

    fun getTotalTaskCnt() = generatedId - deleteCnt
    fun getTaskFinishCnt() = finishCnt

    fun addTask(title: String, content: String, taskBgColor: TaskBgColor){
        taskList.add(createTask(title, content, taskBgColor))
    }

    fun deleteTask(task: Task){
        deleteCnt = deleteCnt.plus(1)
        taskList.remove(task)
        _taskLiveData.value = taskList.toList()
    }

    fun finishTask(task: Task){
        finishCnt = finishCnt.plus(1)
        taskList.remove(task)
        _taskLiveData.value = taskList.toList()
    }

    private fun createTask(title: String, content: String, taskBgColor: TaskBgColor): Task{
        generatedId = generatedId.plus(1)
        return Task(id = generatedId, title = title, content = content, bgColor = taskBgColor)
    }


}