package com.example.ue8_ewinger_benischke

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout

class Task2 : AppCompatActivity() {
    private lateinit var motionLayout: MotionLayout
    private lateinit var button: Button
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task2)

        motionLayout = findViewById(R.id.motionLayout)
        button = findViewById(R.id.button)
        textView = findViewById(R.id.textView)

        button.setOnClickListener {
            if (motionLayout.currentState == R.id.start) {
                motionLayout.transitionToEnd()
                textView.visibility = View.VISIBLE
                button.text = "Hide"
            } else {
                motionLayout.transitionToStart()
                textView.visibility = View.INVISIBLE
                button.text = "Show"
            }
        }
    }



}