package com.example.practice_todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practice_todolist.adapter.TaskAdapter
import com.example.practice_todolist.databinding.ActivityMainBinding
import com.example.practice_todolist.viewmodel.TaskViewModel

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater)}
    private val viewModel by viewModels<TaskViewModel>()
    private var taskAdapter: TaskAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }


    private fun initUI() {
        taskAdapter = TaskAdapter(
            taskFinishEvent = {task -> viewModel.finishTask(task)},
            taskDeleteEvent = {task -> viewModel.deleteTask(task)}
        )

        binding.btnAdd.setOnClickListener{

        }

        with(binding.rvTask){
            setHasFixedSize(true) // 리사이클러뷰 아이템 크기 고정
            adapter = taskAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

    }


}