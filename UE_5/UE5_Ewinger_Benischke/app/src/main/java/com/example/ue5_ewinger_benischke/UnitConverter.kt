package com.example.ue5_ewinger_benischke

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.ComponentActivity

class UnitConverter : ComponentActivity() {

    lateinit var fromEntry: String
    lateinit var toEntry: String
    lateinit var selectedUnit: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_unitconverter)

        val unitSpinner = findViewById<Spinner>(R.id.unit_Spinner)
        val spinnerFrom = findViewById<Spinner>(R.id.spinnerFrom)
        val spinnerTo = findViewById<Spinner>(R.id.spinnerTo)
        val convertBtn = findViewById<Button>(R.id.convert_button)
        val inputField = findViewById<EditText>(R.id.input_field)
        val outputField = findViewById<TextView>(R.id.output_field)

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
                selectedUnit = parent.getItemAtPosition(position).toString()
                when (selectedUnit) {
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
            }
        }

        spinnerFrom.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                fromEntry = parent.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Do nothing
            }
        }

        spinnerTo.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                toEntry = parent.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Do nothing
            }
        }

        convertBtn.setOnClickListener {
            val inputValue = inputField.text.toString().toDouble()
            if (fromEntry == toEntry)
                outputField.text = inputValue.toString()
            else {
                var outputValue = 0.0
                when (selectedUnit) {
                    "time" -> outputValue = convertTime(inputValue)
                }
                outputField.text = outputValue.toString()
            }
        }
    }

    private fun convertTime(time: Double):Double{
        var value = 0.0
        when (fromEntry) {
            "hour" ->
               when (toEntry) {
                    "minute" -> value = time * 60
                    "second" -> value = time * 3600
                }

            "minute" ->
                when (toEntry) {
                    "hour" -> value = time / 60
                    "second" -> value = time * 60
                }

            "second" ->
                when (toEntry) {
                    "minute" -> value = time / 60
                    "hour" -> value = time / 3600
                }
        }
        return value
    }

}