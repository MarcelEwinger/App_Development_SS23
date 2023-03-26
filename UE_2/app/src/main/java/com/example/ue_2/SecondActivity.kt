package com.example.ue_2

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        Log.i(ContentValues.TAG, "SecondActivity onStart");

        val switchToActivity1 = findViewById<Button>(R.id.btnSwitchToActivity1)
        switchToActivity1.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i(ContentValues.TAG, "SecondActivity onStart");
    }

    override fun onResume() {
        super.onResume()
        Log.i(ContentValues.TAG, "SecondActivity onResume");
    }

    override fun onPause() {
        super.onPause()
        Log.i(ContentValues.TAG, "SecondActivity onPause");
    }

    override fun onStop() {
        super.onStop()
        Log.i(ContentValues.TAG, "SecondActivity onPause");
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(ContentValues.TAG, "SecondActivity onDestroy");
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(ContentValues.TAG, "SecondActivity onRestart");
    }
}