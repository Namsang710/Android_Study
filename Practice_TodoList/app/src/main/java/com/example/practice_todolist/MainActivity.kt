package com.example.practice_todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practice_todolist.adapter.TaskAdapter
import com.example.practice_todolist.databinding.ActivityMainBinding
import com.example.practice_todolist.entity.TaskDialog
import com.example.practice_todolist.viewmodel.TaskViewModel

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater)}
    private val viewModel by viewModels<TaskViewModel>()
    private var taskAdapter: TaskAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initUI()
        observeData()
    }


    private fun initUI() {
        taskAdapter = TaskAdapter(
            taskFinishEvent = {task -> viewModel.finishTask(task)},
            taskDeleteEvent = {task -> viewModel.deleteTask(task)}
        )

        binding.btnAdd.setOnClickListener{
            TaskDialog{ title, content, bgColor -> viewModel.addTask(title, content, bgColor)}.show(supportFragmentManager, "TaskDialog" )
        }

        with(binding.rvTask){
            setHasFixedSize(true) // 리사이클러뷰 아이템 크기 고정
            adapter = taskAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

    }

    private fun observeData(){
        viewModel.taskLiveData.observe(this){ taskList ->
            binding.taskTitle.text = resources.getString(R.string.task_title, taskList.size)

            val taskFinishCnt = viewModel.getTaskFinishCnt()
            val taskTotalCnt = viewModel.getTotalTaskCnt()
            binding.tvProgressRate.text = resources.getString(R.string.progress_task_rate, taskFinishCnt, taskTotalCnt)

            with(binding.pbProgress){
                progress = taskFinishCnt
                max = taskTotalCnt
            }

            val percent = if (taskTotalCnt == 0) 0 else taskFinishCnt * 100 / taskTotalCnt
            binding.tvProgressPercent.text = resources.getString(R.string.progress_title, percent)

            binding.tvProgressTitle.text = getProgressTitle(percent)

            binding.taskMsg.text = getTaskMsg(taskTotalCnt)
            binding.taskMsg.visibility = if (taskList.isEmpty()) View.VISIBLE else View.INVISIBLE

            taskAdapter?.submitList(taskList)
        }
    }


    private fun getProgressTitle(percent : Int) : String{
        return if (percent == 100){
            resources.getString(R.string.progress_title_finish)
        }else if(percent >= 30){
            resources.getString(R.string.progress_title_ing)
        }else{
            resources.getString(R.string.progress_title_start)
        }
    }

    private fun getTaskMsg(totalCnt : Int) : String{
        return if (totalCnt == 0){
            resources.getString(R.string.task_empty_msg)
        }else{
            resources.getString(R.string.task_done_msg)
        }

    }


}