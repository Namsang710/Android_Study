package com.example.practice_customcalender

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.practice_customcalender.databinding.ListItemMonthBinding
import java.util.Calendar
import java.util.Date

class AdapterMonth: RecyclerView.Adapter<AdapterMonth.ViewHolder>() {

    val center = Int.MAX_VALUE / 2
    private var calendar = Calendar.getInstance()

    inner class ViewHolder(private val binding:ListItemMonthBinding):RecyclerView.ViewHolder(binding.root){
        val tvMonth : TextView = binding.tvMonthText
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListItemMonthBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        calendar.time = Date()
        calendar.set(Calendar.DAY_OF_MONTH, 1)
        calendar.add(Calendar.MONTH, position-center)
        holder.tvMonth.text = "${calendar.get(Calendar.YEAR)}년 ${calendar.get(Calendar.MONTH)+1}월"
        val tempMonth = calendar.get(Calendar.MONTH)


    }

    override fun getItemCount(): Int {
        return Int.MAX_VALUE
    }

}