package com.example.practice_customcalender

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practice_customcalender.databinding.ListItemMonthBinding
import java.util.Calendar
import java.util.Date

class AdapterMonth: RecyclerView.Adapter<AdapterMonth.ViewHolder>() {

    val center = Int.MAX_VALUE / 2
    private var calendar = Calendar.getInstance()

    inner class ViewHolder(private val binding:ListItemMonthBinding):RecyclerView.ViewHolder(binding.root){
        val layout = binding.listItemLayout
        val tvMonth : TextView = binding.tvMonthText
        val monthList = binding.itemMonthDayList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListItemMonthBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        calendar.time = Date() // 현재 날짜로 초기화
        calendar.set(Calendar.DAY_OF_MONTH, 1) // 현재 월의 1일로 이동
        calendar.add(Calendar.MONTH, position-center)
        holder.tvMonth.text = "${calendar.get(Calendar.YEAR)}년 ${calendar.get(Calendar.MONTH)+1}월"
        val tempMonth = calendar.get(Calendar.MONTH) // 현재의 월 저장

        var dayList:MutableList<Date> = MutableList(6*7){Date()}
        for(i in 0..5){
            for (k in 0..6){
                calendar.add(Calendar.DAY_OF_MONTH, (1-calendar.get(Calendar.DAY_OF_WEEK)) + k)
                dayList[i * 7 + k] = calendar.time
            }
            calendar.add(Calendar.WEEK_OF_MONTH, 1)

        }

        val dayListManager = GridLayoutManager(holder.layout.context, 7)
        val dayListAdapter = AdapterDay(tempMonth, dayList)

        holder.monthList.apply{
            layoutManager = dayListManager
            adapter = dayListAdapter
        }

    }

    override fun getItemCount(): Int {
        return Int.MAX_VALUE
    }

}