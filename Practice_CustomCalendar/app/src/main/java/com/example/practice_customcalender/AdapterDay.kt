package com.example.practice_customcalender

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.practice_customcalender.databinding.ListItemDayBinding
import com.example.practice_customcalender.databinding.ListItemMonthBinding
import java.util.Date

class AdapterDay(val tempMonth:Int, val dayList:MutableList<Date>) : RecyclerView.Adapter<AdapterDay.ViewHolder>() {

    private final val ROW = 6 // 최대 6주
    inner class ViewHolder(private val binding: ListItemDayBinding):RecyclerView.ViewHolder(binding.root){
        val layout = binding.itemDayLayout
        val tvDay = binding.itemDayText
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListItemDayBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.layout.setOnClickListener{
            Toast.makeText(holder.layout.context, "${dayList[position]}", Toast.LENGTH_SHORT).show()
        }

        holder.tvDay.text = dayList[position].date.toString()

        holder.tvDay.setTextColor(when(position % 7){
            0 -> Color.RED
            6 -> Color.BLUE
            else -> Color.BLACK
        })

        if(tempMonth != dayList[position].month){ // 현재 월이 아닌 날짜의 경우엔 투명도 낮춰서 현재 월의 날짜와 다르게 표시
            holder.tvDay.alpha = 0.4f
        }

    }

    override fun getItemCount(): Int {
        return ROW * 7
    }

}