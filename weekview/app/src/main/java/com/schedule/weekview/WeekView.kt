package com.schedule.weekview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.ScrollView
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.weekview.*
import kotlinx.android.synthetic.main.weekview.view.*
import java.util.zip.Inflater

class WeekView : AppCompatActivity() {

    val model=Model()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.weekview)
        val model=Model()
    }
    fun getDayTasks(button: Button){
        val day=Model.Day.valueOf(button.text.toString())

        val intent= Intent(this,DayView::class.java)
         intent.putExtra("Model",model)
        startActivity(intent)
    }
}