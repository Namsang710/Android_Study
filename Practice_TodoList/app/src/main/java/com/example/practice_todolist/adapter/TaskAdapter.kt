package com.example.practice_todolist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.practice_todolist.databinding.ItemTaskBinding
import com.example.practice_todolist.entity.Task

class TaskAdapter(
    private val taskFinishEvent : (Task) -> Unit,
    private val taskDeleteEvent : (Task) -> Unit
) : ListAdapter<Task, TaskAdapter.TaskViewHolder>(TaskDiffUtil){

    inner class TaskViewHolder(private val binding : ItemTaskBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(task : Task){
            val finishClickListener = View.OnClickListener { taskFinishEvent(task) }
            val deleteClickListener = View.OnClickListener { taskDeleteEvent(task) }

            with(binding){
                itemTaskLayout.background = AppCompatResources.getDrawable(itemView.context, task.bgColor.background)
                tvItemTaskTitle.text = task.title
                tvItemTaskContent.text = task.content
                icItemTaskFinish.setOnClickListener(finishClickListener)
                icItemTaskDelete.setOnClickListener(deleteClickListener)
            }

        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val binding = ItemTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TaskViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    companion object {
        object TaskDiffUtil : DiffUtil.ItemCallback<Task>(){
            override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean {
                return oldItem.id == newItem.id
            }

        }
    }


}