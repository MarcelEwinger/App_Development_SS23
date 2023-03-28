package com.example.ue_2

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    //
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i(TAG, "MainActivity onCreate");

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            //Toast.makeText(applicationContext,R.string.toast,Toast.LENGTH_SHORT).show()
            Toast.makeText(applicationContext,"Hey, I'm doing something",Toast.LENGTH_SHORT).show()
        }

        val switchToActivity2 = findViewById<Button>(R.id.btnSwitchToActivity2)
        switchToActivity2.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        val switchToActivity3 = findViewById<Button>(R.id.btnSwitchToActivity3)
        switchToActivity3.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }

        Log.v(TAG, "This is a verbose message");
        Log.d(TAG, "This is a debug message");
        Log.i(TAG, "This is an info message");
        Log.w(TAG, "This is a warning message");
        Log.e(TAG, "This is an error message");
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "MainActivity onStart");
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "MainActivity onResume");
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "MainActivity onPause");
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "MainActivity onPause");
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "MainActivity onDestroy");
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG, "MainActivity onRestart");
    }
}