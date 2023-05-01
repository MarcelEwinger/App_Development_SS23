package com.example.ue4_ewinger_benischke

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.activity.ComponentActivity


class InfoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

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
            val url = "https://m.facebook.com/uniklagenfurt/"
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
}
