package com.example.ue3_ewinger_benischke

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class ServiceActivity : AppCompatActivity() {

    private lateinit var startButton: Button
    private lateinit var stopButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)

        startButton = findViewById(R.id.startButton)
        stopButton = findViewById(R.id.stopButton)
    }

    /**
     * Start the service
     */
    fun onStartMusic(view: View) {
        val intent = Intent(this, AudioService::class.java)
        startService(intent)
    }

    /**
     * Stopp the service
     */
    fun onStopMusic(view: View) {
        val intent = Intent(this, AudioService::class.java)
        stopService(intent)
    }
}