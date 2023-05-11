package com.example.ue_6_ewingerbenischke


import android.content.pm.PackageManager
import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.os.Build
import android.content.Context


class Task1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val isTV = isTVDevice(this)
        val isWidescreen = isWidescreenDevice(this)
        val isSmall = isSmallDevice(this)

        // Das richtige Layout basierend auf der Bildschirmgröße auswählen
        if (isWidescreen) {
            setContentView(R.layout.widescreen_layout) // Widescreen-Layout
        } else if (isTV) {
            setContentView(R.layout.television_layout) // TV-Layout
        }else if(isSmall){
            setContentView(R.layout.small_layout) // Small-Layout
        }else {
            setContentView(R.layout.activity_task1) // Normal-Layout
        }



    }

    // Methode zur Überprüfung, ob es sich um ein Widescreen-Gerät handelt
    private fun isWidescreenDevice(context: Context): Boolean {
        val configuration = context.resources.configuration

        // Überprüfen, ob es sich um ein TV-Gerät handelt
        if (isTVDevice(context)) {
            return false
        }

        // Überprüfen, ob die Bildschirmbreite größer als die Höhe ist
        return configuration.orientation == Configuration.ORIENTATION_LANDSCAPE &&
                configuration.screenWidthDp > configuration.screenHeightDp
    }

    // Methode zur Überprüfung, ob es sich um ein TV-Gerät handelt
    private fun isTVDevice(context: Context): Boolean {
        val packageManager = context.packageManager
        val systemFeatures = packageManager.systemAvailableFeatures

        // Überprüfen, ob das Gerät den "FEATURE_TELEVISION" System-Feature hat
        for (feature in systemFeatures) {
            if (PackageManager.FEATURE_TELEVISION == feature.name) {
                return true
            }
        }
        // Alternativ: Überprüfen, ob die Bildschirmgröße und Ausrichtung für TV sprechen
        val configuration = context.resources.configuration
        return configuration.uiMode and Configuration.UI_MODE_TYPE_MASK == Configuration.UI_MODE_TYPE_TELEVISION
    }

    private fun isSmallDevice(context: Context): Boolean {
        val configuration = context.resources.configuration

        // Überprüfen, ob es sich um ein TV-Gerät handelt
        if (isTVDevice(context)) {
            return false
        }

        // Überprüfen der Bildschirmgröße und -dichte
        return configuration.screenWidthDp <= 240 &&
                configuration.screenHeightDp <= 320 &&
                configuration.densityDpi <= 160
    }

}