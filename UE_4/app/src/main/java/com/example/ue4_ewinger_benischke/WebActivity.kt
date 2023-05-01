package com.example.ue4_ewinger_benischke

import android.os.Bundle
import android.webkit.WebView
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity

class WebActivity : ComponentActivity() {

    private lateinit var webView: WebView
    private lateinit var editTextUrl: EditText
    private lateinit var buttonLoad: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        webView = findViewById(R.id.web_view)
        editTextUrl = findViewById(R.id.edit_text_url)
        buttonLoad = findViewById(R.id.button_load)

        // Set onClickListener to load webpage
        buttonLoad.setOnClickListener {
            val url = editTextUrl.text.toString()
            webView.loadUrl(url)
        }
    }
}
