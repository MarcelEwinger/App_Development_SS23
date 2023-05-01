package com.example.ue4_ewinger_benischke


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/*
private const val DEBUG_TAG = "Gestures"
private lateinit var view: View
private lateinit var mDetector: GestureDetectorCompat

 */


class MainActivity : AppCompatActivity(){

    private lateinit var singleTouchView: SingleTouchView
    private lateinit var multiTouchView: MultiTouchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        singleTouchView = findViewById(R.id.singleTouchView)
        multiTouchView = findViewById(R.id.multiTouchView)

    }

}