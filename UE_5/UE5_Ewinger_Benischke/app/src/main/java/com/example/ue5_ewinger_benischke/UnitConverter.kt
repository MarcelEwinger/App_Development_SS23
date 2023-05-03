package com.example.ue5_ewinger_benischke

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.activity.ComponentActivity

class UnitConverter : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_unitconverter)

        val unitSpinner = findViewById<Spinner>(R.id.unit_Spinner)
        val spinnerFrom = findViewById<Spinner>(R.id.spinnerFrom)
        val spinnerTo = findViewById<Spinner>(R.id.spinnerTo)

        val lengthArray = resources.getStringArray(R.array.unit_length)
        val weightArray = resources.getStringArray(R.array.unit_weight)
        val temperatureArray = resources.getStringArray(R.array.unit_temperature)
        val volumeArray = resources.getStringArray(R.array.unit_volume)
        val timeArray = resources.getStringArray(R.array.unit_time)

        val lengthAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item,lengthArray)
        lengthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        val weightAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item,weightArray)
        weightAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        val temperatureAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item,temperatureArray)
        temperatureAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        val volumeAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item,volumeArray)
        volumeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        val timeAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item,timeArray)
        timeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        unitSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                when (parent.getItemAtPosition(position).toString()) {
                    "length" -> {spinnerFrom.adapter = lengthAdapter
                                spinnerTo.adapter = lengthAdapter}
                    "weight" -> {spinnerFrom.adapter = weightAdapter
                                spinnerTo.adapter = weightAdapter}
                    "temperature" -> {spinnerFrom.adapter = temperatureAdapter
                                    spinnerTo.adapter = temperatureAdapter}
                    "volume" -> {spinnerFrom.adapter = volumeAdapter
                                spinnerTo.adapter = volumeAdapter}
                    "time" -> {spinnerFrom.adapter = timeAdapter
                            spinnerTo.adapter = timeAdapter}
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Do nothing
                println("Nothing selected")
            }
        }
    }


}