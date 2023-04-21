package com.example.ue3_ewinger_benischke

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    private var receivedAddress = "";
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val textView = findViewById<TextView>(R.id.textView)

        receivedAddress = intent.getStringExtra("addressValue").toString()
        textView.text = receivedAddress

    }

    fun onButtonClickMaps(view: View) {
        // Create a Uri with the location data
        val uri = Uri.parse("geo:0,0?q=$receivedAddress")

        // Start an Intent to open Google Maps with the Uri
        val mapsIntent = Intent(Intent.ACTION_VIEW, uri)
        mapsIntent.setPackage("com.google.android.apps.maps")
        startActivity(mapsIntent)
    }
}