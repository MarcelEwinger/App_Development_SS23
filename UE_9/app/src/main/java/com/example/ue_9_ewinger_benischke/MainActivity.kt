package com.example.ue_9_ewinger_benischke

import android.content.Intent
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

        btnProject1.setOnClickListener {
            val intent = Intent(this, Task1::class.java)
            startActivity(intent)
        }

        btnProject2.setOnClickListener {
            val intent = Intent(this, Task2::class.java)
            startActivity(intent)
        }

        btnProject3.setOnClickListener {
            val intent = Intent(this, Task3::class.java)
            startActivity(intent)
        }

        btnProject4.setOnClickListener {
            val intent = Intent(this, Task4::class.java)
            startActivity(intent)
        }


    }
}