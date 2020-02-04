package com.schedule.weekview

import android.service.autofill.OnClickAction
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ActionsAdapter(val listAcrions:List<Action>):RecyclerView.Adapter<ScheduleViewHolder>() {

    enum class HolderType{
        USER,STUDY
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder {
        if(viewType==HolderType.USER.ordinal){
            val view=LayoutInflater.from(parent.context).inflate(R.layout.user_layout,parent)
            return UserViewHolder(view)
        }
        val view=LayoutInflater.from(parent.context).inflate(R.layout.study_layout,parent)
        return StudyViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        if(listAcrions[position] is UserAction)
            return HolderType.STUDY.ordinal
        else if(listAcrions[position] is StudyAction)
            return HolderType.USER.ordinal
        else
            return -1
    }

    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int) {
        holder.setData(listAcrions[position])
        val view:View?=holder.itemView
        holder.itemView.setOnClickListener {view->holder.onClick(position)}
    }

    override fun getItemCount(): Int {
        return listAcrions.size
    }

    inner class StudyViewHolder(view:View):ScheduleViewHolder(view){
        override var head:TextView=view.findViewById(R.id.headStudy)
        override var time:TextView=view.findViewById(R.id.timeUser)
        override fun setData(action: Action){
            val list=action.getParams()
            head.setText(list[0])
            time.setText(list[1])
        }

        override fun onClick(index: Int) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    }
    inner class UserViewHolder(view:View):ScheduleViewHolder(view){
        override var head:TextView=view.findViewById(R.id.headUser)
        override var time:TextView=view.findViewById(R.id.timeUser)
        override fun setData(action: Action){
            val list=action.getParams()
            head.setText(list[0])
            time.setText(list[1])
        }
        override fun onClick(index: Int) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    }


}