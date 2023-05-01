package com.example.ue4_ewinger_benischke


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity




class MainActivity : AppCompatActivity(){

    private lateinit var singleTouchView: SingleTouchView
    private lateinit var multiTouchView: MultiTouchView

    private lateinit var btnLayout: Button
    private lateinit var btnConstraint: Button
    private lateinit var btnWebBrowser: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        singleTouchView = findViewById(R.id.singleTouchView)
        multiTouchView = findViewById(R.id.multiTouchView)

        btnLayout = findViewById(R.id.btnLayout)
        btnConstraint = findViewById(R.id.btnConstraint)
        btnWebBrowser = findViewById(R.id.btnWebBrowser)

        btnLayout.setOnClickListener {
            val intent = Intent(this, LayoutActivity::class.java)
            startActivity(intent)
        }

        btnConstraint.setOnClickListener {
            val intent = Intent(this, InfoActivity::class.java)
            startActivity(intent)
        }

        btnWebBrowser.setOnClickListener {
            val intent = Intent(this, WebActivity::class.java)
            startActivity(intent)
        }
    }


}