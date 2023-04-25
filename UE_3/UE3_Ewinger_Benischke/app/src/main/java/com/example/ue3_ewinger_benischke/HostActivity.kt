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

    /**
     * Is called and displays a message when a fragment sends a message
     */
    override fun onMessageReceived(message: String) {
        val text = findViewById<TextView>(R.id.textView3)
        text.text = message
    }

    /**
     * Ends the activity if the back button is pressed
     */
    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        finish()
    }

    /**
     * Initializes the buttons, the switch
     * Uses fragmentManager to replace the fragments on the page and also to access the displayed fragment to send a message
     */
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_host2)

        //Find the button view by its ID
        val btnFragmentB = findViewById<Button>(R.id.button_fragmentB)
        /**
         * When this button is clicked,
         * a new instance of the fragment FragmentB is created and added to the container with the ID fragmentContainerView2.
         */
        btnFragmentB.setOnClickListener {
            val fragmentManager: FragmentManager = supportFragmentManager //Instance of FragmentManager
            fragmentManager.beginTransaction() //start a new transaction describing the changes to the fragment instance.
                .replace(R.id.fragmentContainerView2, FragmentB::class.java, null)
                //current fragment in fragmentContainerView2 with a new instance of fragment[].
                .setReorderingAllowed(true) //is called to ensure that the transactions are executed in the correct order.
                .addToBackStack("name") // name can be null
                .commit()
        }

        val btnFragmentA = findViewById<Button>(R.id.button_fragmentA)
        /**
         * When this button is clicked,
         * a new instance of the fragment FragmentB is created and added to the container with the ID fragmentContainerView2.
         */
        btnFragmentA.setOnClickListener {
            val fragmentManager: FragmentManager = supportFragmentManager //Instance of FragmentManager
            fragmentManager.beginTransaction()//start a new transaction describing the changes to the fragment instance.
                //current fragment in fragmentContainerView2 with a new instance of fragment[].
                .replace(R.id.fragmentContainerView2, FragmentA::class.java, null)

                .setReorderingAllowed(true)//is called to ensure that the transactions are executed in the correct order.
                .addToBackStack("name") // name can be null
                .commit()
        }


        val btnSend = findViewById<Button>(R.id.btn_send)
        /**
         * Send text to Fragment
         */
        btnSend.setOnClickListener {
            val fragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView2)//find the fragmentID
            val text = findViewById<TextView>(R.id.textInput)
            if(fragment is FragmentB) {//check if the fragment in the fragment variable is a fragmentB
                fragment.updateText(text.text.toString())
            } else if (fragment is FragmentA) {//check if the fragment in the fragment variable is a fragmentA
                fragment.updateText(text.text.toString())
            } else {
                Toast.makeText(this, "You can only send a message to the displaying fragment", Toast.LENGTH_SHORT).show()
            }

        }
    }
}

