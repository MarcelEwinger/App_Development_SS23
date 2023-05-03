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

    lateinit var fromUnit: String
    lateinit var toUnit: String
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
                fromUnit = parent.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Do nothing
            }
        }

        spinnerTo.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                toUnit = parent.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Do nothing
            }
        }

        convertBtn.setOnClickListener {
            val inputValue = inputField.text.toString().toDouble()
            if (fromUnit == toUnit)
                outputField.text = inputValue.toString()
            else {
                var outputValue = 0.0
                when (selectedUnit) {
                    "weight" -> outputValue = convertWeight(inputValue)
                    "temperature" -> outputValue = convertTemperature(inputValue)
                    "volume" -> outputValue = convertVolume(inputValue)
                    "time" -> outputValue = convertTime(inputValue)
                }
                outputField.text = outputValue.toString()
            }
        }
    }

    private fun convertVolume(volume:Double):Double {
        var value = 0.0

        when (fromUnit) {
            "liter" -> {
                when (toUnit) {
                    "milliliter" -> value = volume * 1000
                    "gallon" -> value = volume * 0.264172
                    "fluid ounce" -> value = volume * 33.814
                }
            }

            "milliliter" -> {
                when (toUnit) {
                    "liter" -> value = volume / 1000
                    "gallon" -> value = volume * 0.000264172
                    "fluid ounce" -> value = volume * 0.033814
                }
            }

            "gallon" -> {
                when (toUnit) {
                    "liter" -> value = volume * 3.78541
                    "milliliter" -> value = volume * 3785.41
                    "fluid ounce" -> value = volume * 128
                }
            }

            "fluid ounce" -> {
                when (toUnit) {
                    "liter" -> value = volume * 0.0295735
                    "milliliter" -> value = volume * 29.5735
                    "gallon" -> value = volume * 0.0078125
                }
            }
        }

        return value
    }

    private fun convertWeight(weight: Double):Double{
        var value = 0.0

        when (fromUnit) {
            "kilogram" -> {
                when (toUnit) {
                    "gram" -> value = weight * 1000
                    "pound" -> value = weight * 2.20462
                    "ounce" -> value = weight * 35.274
                }
            }
            "gram" -> {
                when (toUnit) {
                    "kilogram" -> value = weight / 1000
                    "pound" -> value = weight * 0.00220462
                    "ounce" -> value = weight * 0.035274
                }
            }
            "pound" -> {
                when (toUnit) {
                    "kilogram" -> value = weight * 0.453592
                    "gram" -> value = weight * 453.592
                    "ounce" -> value = weight * 16
                }
            }
            "ounce" -> {
                when (toUnit) {
                    "kilogram" -> value = weight * 0.0283495
                    "gram" -> value = weight * 28.3495
                    "pound" -> value = weight * 0.0625
                }
            }
        }

        return value

    }

    private fun convertTemperature(temperature:Double):Double {
        var value = 0.0
        val absoluteZero = 273.15
        when (fromUnit) {
            "celsius" ->
                when (toUnit) {
                    "fahrenheit" -> value = (temperature * 9/5) + 32
                    "kelvin" -> value = temperature + absoluteZero
                }
            "fahrenheit" ->
                when (toUnit) {
                    "celsius" -> value = (temperature - 32) * 5/9
                    "kelvin" -> value = (temperature - 32) * 5/9 + absoluteZero
                }
            "kelvin" ->
                when (toUnit) {
                    "celsius" -> value = temperature - absoluteZero
                    "fahrenheit" -> value = (temperature - absoluteZero) * 9/5 + 32
                }
        }
        return value
    }

    private fun convertTime(time: Double):Double{
        var value = 0.0
        when (fromUnit) {
            "hour" ->
               when (toUnit) {
                    "minute" -> value = time * 60
                    "second" -> value = time * 3600
                }

            "minute" ->
                when (toUnit) {
                    "hour" -> value = time / 60
                    "second" -> value = time * 60
                }

            "second" ->
                when (toUnit) {
                    "minute" -> value = time / 60
                    "hour" -> value = time / 3600
                }
        }
        return value
    }

}