package com.example.ue_9_ewinger_benischke

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Task4 : AppCompatActivity() {

    private lateinit var batteryLevelReceiver: BatteryLevelReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task4)
        batteryLevelReceiver = BatteryLevelReceiver()
    }

    /**
     * Wird dynamisch hinzugefügt und nicht statisch (Manifest)
     */
    override fun onStart() {
        super.onStart()
        registerBatteryLevelReceiver()
    }

    override fun onStop() {
        super.onStop()
        unregisterBatteryLevelReceiver()
    }

    /**
     * Die Methode registerBatteryLevelReceiver() wird verwendet, um den BatteryLevelReceiver
     * zu registrieren und ihn für den Empfang von Broadcasts über Änderungen des Batteriestandes zu aktivieren.
     */
    private fun registerBatteryLevelReceiver() {
        val filter = IntentFilter(Intent.ACTION_BATTERY_CHANGED)
        registerReceiver(batteryLevelReceiver, filter)
    }

    /**
     * Die Methode unregisterBatteryLevelReceiver() wird verwendet, um den
     * zuvor registrierten BatteryLevelReceiver zu deaktivieren und ihn
     * aus dem Android-Broadcast-System zu entfernen.
     */
    private fun unregisterBatteryLevelReceiver() {
        unregisterReceiver(batteryLevelReceiver)
    }
}