package com.example.ue_6_ewingerbenischke


import android.content.pm.PackageManager
import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.os.Build
import android.content.Context
import android.content.ActivityNotFoundException
import android.content.ContentValues.TAG
import android.content.Intent
import android.net.Uri
import android.util.Log

import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.activity.ComponentActivity


class Task1 : AppCompatActivity() {
    private val TAG = "LAYOUT"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val isTV = isTVDevice(this)
        val isWidescreen = isWidescreenDevice(this)
        val isSmall = isSmallDevice(this)


        // Das richtige Layout basierend auf der Bildschirmgröße auswählen
        if (isWidescreen) {
            setContentView(R.layout.activity_task1) // Widescreen-Layout
            Log.d(TAG, "Widescreen-Layout")
        } else if (isTV) {
            setContentView(R.layout.television_layout) // TV-Layout
            Log.d(TAG, "TV-Layout")
        }else if(isSmall){
            setContentView(R.layout.small_layout) // Small-Layout
            Log.d(TAG, "Small-Layout")
        }else {
            setContentView(R.layout.activity_task1) // Normal-Layout
            Log.d(TAG, "Normal-Layout")
        }

        // Aktiviere den Vollbildmodus
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)


        val exitButton = findViewById<ImageButton>(R.id.btnExit)
        exitButton.setOnClickListener {
            finish()
        }

        val facebookButton = findViewById<ImageButton>(R.id.facebook_icon)
        facebookButton.setOnClickListener {
            val url = "https://www.facebook.com/uniklagenfurt/"
            val facebookIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(facebookIntent)
        }
        val twitterButton = findViewById<ImageButton>(R.id.twitter_icon)
        twitterButton.setOnClickListener {
            val url = "https://twitter.com/alpenadriauni?lang=de"
            val twitterIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(twitterIntent)
        }
        val instagramButton = findViewById<ImageButton>(R.id.instagram_icon)
        instagramButton.setOnClickListener {
            val url = "https://www.instagram.com/uniklagenfurt/?hl=de"
            val instagramIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(instagramIntent)
        }
        val mailButton = findViewById<ImageButton>(R.id.email_icon)
        mailButton.setOnClickListener {
            try {
                val mailIntent = Intent(Intent.ACTION_SENDTO)
                mailIntent.data = Uri.parse("mailto:") // only email apps should handle this
                mailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("kobenischke@edu.aau.at"))
                mailIntent.putExtra(Intent.EXTRA_SUBJECT, "App feedback")
                startActivity(mailIntent)
            } catch (ex: ActivityNotFoundException) {
                Toast.makeText(this,
                    "There are no email client installed on your device.",LENGTH_SHORT
                ).show()
            }
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