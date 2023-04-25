package com.example.ue3_ewinger_benischke


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    val TAG = "StateChanges"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i(TAG, "onCreate")

    }


    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.i(TAG, "onSaveInstanceState")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.i(TAG, "onRestoreInstanceState")
    }

    /**
     * Switch to Act. 2
     */
    fun onButtonClick(view: View) {
        val address = findViewById<EditText>(R.id.editText).text.toString()
        if (address.isNotEmpty()){//check if textField is not empty
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("addressValue", address)
            startActivity(intent)
            }else{
            Toast.makeText(applicationContext, "Please enter address!!!",
                Toast.LENGTH_LONG).show();
        }

    }

    fun onButtonClickSwitchToService(view: View) {
        val intent = Intent(this, ServiceActivity::class.java)
        startActivity(intent)
    }

    fun onButtonClickSwitchToHost(view: View) {
        val intent = Intent(this, HostActivity::class.java)
        startActivity(intent)
    }

    fun onButtonClickSwitchToTouchGame(view: View) {
        val intent = Intent(this, TouchActivity::class.java)
        startActivity(intent)
    }
}
