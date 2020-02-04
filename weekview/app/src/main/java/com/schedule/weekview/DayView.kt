package com.schedule.weekview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DayView: AppCompatActivity(){
    lateinit var model:Model

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dayview)

        val container=findViewById<RecyclerView>(R.id.content_view)
        container.layoutManager=LinearLayoutManager(this)
        model=intent.getParcelableExtra("Model")
    }
    fun addActions(){

    }
    fun addUserAction(){

    }

}