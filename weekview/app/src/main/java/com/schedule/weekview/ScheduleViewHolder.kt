package com.schedule.weekview

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

abstract class ScheduleViewHolder(view: View) :RecyclerView.ViewHolder(view){
    abstract var head: TextView
    abstract var time:TextView
    abstract fun setData(action: Action)
    abstract fun onClick(index:Int)
}