package com.example.ue8_ewinger_benischke

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.constraintlayout.motion.widget.MotionLayout
import java.text.SimpleDateFormat
import java.util.Calendar

class Task4 : AppCompatActivity() {
    private lateinit var readValues: Button
    private lateinit var date: DatePicker
    private lateinit var time: TimePicker

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task4)

        readValues = findViewById(R.id.btn)
        date = findViewById(R.id.datepicker)
        time = findViewById(R.id.timepicker)
        time.setIs24HourView(true);

        val calendar: Calendar = Calendar.getInstance()


        readValues.setOnClickListener(){
            calendar.set(date.year, date.month, date.dayOfMonth)
            val simpleDateFormat = SimpleDateFormat("dd.MM.yyyy")
            val formatted: String = simpleDateFormat.format(calendar.time)
            val hour = time.hour
            val min = time.minute
            Toast.makeText(this, "$formatted um $hour:$min", Toast.LENGTH_SHORT).show();
        }
    }
}