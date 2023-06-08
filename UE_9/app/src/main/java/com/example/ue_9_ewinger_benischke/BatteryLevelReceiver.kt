package com.example.ue_9_ewinger_benischke

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.BatteryManager
import android.util.Log

/**
 * A BroadcastReceiver that listens for battery level changes and logs the battery level.
 */
class BatteryLevelReceiver : BroadcastReceiver() {
    /**
     * Called when a broadcast is received.
     *
     * @param context The context in which the receiver is running.
     * @param intent  The intent being received.
     */
    override fun onReceive(context: Context, intent: Intent) {
        // Get the battery level and scale from the intent extras
        val level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
        val scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1)

        // Calculate the battery level as a percentage
        val batteryLevel = level / scale.toFloat()

        // Log the battery level
        Log.d("BatteryLevelReceiver", "Battery Level: ${(batteryLevel * 100)}%")
    }
}