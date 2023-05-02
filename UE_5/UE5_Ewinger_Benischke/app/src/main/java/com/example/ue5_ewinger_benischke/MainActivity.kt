package com.example.ue5_ewinger_benischke

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var btnProject1: Button
    private lateinit var btnProject2: Button
    private lateinit var btnProject3: Button
    private lateinit var btnProject4: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnProject1 = findViewById(R.id.btnProject1)
        btnProject2 = findViewById(R.id.btnProject2)
        btnProject3 = findViewById(R.id.btnProject3)
        btnProject4 = findViewById(R.id.btnProject4)
    }
}