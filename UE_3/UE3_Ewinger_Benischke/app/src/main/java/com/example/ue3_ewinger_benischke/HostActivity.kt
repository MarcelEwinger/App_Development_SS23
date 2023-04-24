package com.example.ue3_ewinger_benischke

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager


class HostActivity : AppCompatActivity(), FragmentA.FragmentListener {

    override fun onMessageReceived(message: String) {
        val text = findViewById<TextView>(R.id.textView3)
        text.text = message;
    }

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_host2)

        //Find the button view by its ID
        val btnFragmentB = findViewById<Button>(R.id.button_fragmentB)
        btnFragmentB.setOnClickListener {
            val fragmentManager: FragmentManager = supportFragmentManager
            fragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView2, FragmentB::class.java, null)
                .setReorderingAllowed(true)
                .addToBackStack("name") // name can be null
                .commit()
        }

        val btnFragmentA = findViewById<Button>(R.id.button_fragmentA)
        btnFragmentA.setOnClickListener {
            val fragmentManager: FragmentManager = supportFragmentManager
            fragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView2, FragmentA::class.java, null)
                .setReorderingAllowed(true)
                .addToBackStack("name") // name can be null
                .commit()
        }
        val switch = findViewById<Switch>(R.id.switch1)
        switch.setOnClickListener {
            if(switch.isChecked)
                switch.text = getString(R.string.SwitchTextB)
            else
                switch.text = getString(R.string.SwitchTextA)
        }


        val btnSend = findViewById<Button>(R.id.btn_send)
        btnSend.setOnClickListener {

            val fragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView2)
            val text = findViewById<TextView>(R.id.textInput)
            if(switch.isChecked && fragment is FragmentB) {
                fragment.updateText(text.text.toString())
            } else if (!switch.isChecked && fragment is FragmentA) {
                fragment.updateText(text.text.toString())
            } else {
                Toast.makeText(this, "You can only send a message to the displaying fragment", Toast.LENGTH_SHORT).show()
            }

        }
    }
}

