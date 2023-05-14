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
import android.content.res.Resources
import android.net.Uri
import android.util.Log

import android.view.View
import android.view.WindowManager
import android.widget.ImageButton
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.activity.ComponentActivity
import androidx.core.content.ContextCompat


class Task1 : AppCompatActivity() {
    private val TAG = "LAYOUT"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val isTV = isTVDevice(this)
        val isSmall = isSmallDevice(this)


        // Das richtige Layout basierend auf der Bildschirmgröße auswählen
        if (isTV) {
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


    // Methode zur Überprüfung, ob es sich um ein TV-Gerät handelt
    private fun isTVDevice(context: Context): Boolean {
        return(packageManager.hasSystemFeature(PackageManager.FEATURE_TELEVISION)
                || packageManager.hasSystemFeature(PackageManager.FEATURE_LEANBACK));
    }

    //Methode zur Überprüfung, ob es sich um ein "Small" Device handelt
    private fun isSmallDevice(context: Context): Boolean {
        val displayMetrics = Resources.getSystem().displayMetrics
        val screenWidth = displayMetrics.widthPixels
        val screenHeight = displayMetrics.heightPixels
        return (screenWidth == 240 && screenHeight == 320) || (screenWidth == 320 && screenHeight == 240)
    }


}