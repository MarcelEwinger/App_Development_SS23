package com.example.ue_2

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        Log.i(ContentValues.TAG, "ThirdActivity onCreate");

        val switchToActivity1 = findViewById<Button>(R.id.btnSwitchToActivity1)
        switchToActivity1.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i(ContentValues.TAG, "ThirdActivity onStart");
    }

    override fun onResume() {
        super.onResume()
        Log.i(ContentValues.TAG, "ThirdActivity onResume");
    }

    override fun onPause() {
        super.onPause()
        Log.i(ContentValues.TAG, "ThirdActivity onPause");
    }

    override fun onStop() {
        super.onStop()
        Log.i(ContentValues.TAG, "ThirdActivity onPause");
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(ContentValues.TAG, "ThirdActivity onDestroy");
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(ContentValues.TAG, "ThirdActivity onRestart");
    }
}