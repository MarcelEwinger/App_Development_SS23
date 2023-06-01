package com.example.ue8_ewinger_benischke

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatDelegate

class Task1 : AppCompatActivity() {
    private lateinit var radioGroup: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        // Set the initial theme based on the "isDarkTheme" flag
        //setTheme(R.style.Theme_UE8_Ewinger_Benischke)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task1)
        radioGroup = findViewById(R.id.idRGgroup)

        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.idRBLight -> {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                }
                R.id.idRBDark -> {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                }
            }
        }








    }

}