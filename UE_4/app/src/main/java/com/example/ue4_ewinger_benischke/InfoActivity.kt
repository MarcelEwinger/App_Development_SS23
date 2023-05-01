package com.example.ue4_ewinger_benischke

import android.os.Bundle
import android.view.Surface
import android.widget.ImageButton
import androidx.activity.ComponentActivity


class InfoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        val exitButton = findViewById<ImageButton>(R.id.btnExit)
        exitButton.setOnClickListener {
            finish()
        }
    }
}
