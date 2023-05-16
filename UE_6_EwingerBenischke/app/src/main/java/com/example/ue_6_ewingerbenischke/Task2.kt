package com.example.ue_6_ewingerbenischke

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import com.example.ue_6_ewingerbenischke.databinding.ActivityTask2Binding

class Task2 : AppCompatActivity() {
    // Initialize variables
    private lateinit var binding: ActivityTask2Binding
    private lateinit var fromUnit: String
    private lateinit var toUnit: String
    private lateinit var selectedUnit: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTask2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        //die als Schlüssel String-Namen von verschiedenen Maßeinheiten und als Werte Arrays von
        // Strings enthält, die die verschiedenen Einheiten in jeder Kategorie darstellen.
        val units = mapOf(
            "length" to resources.getStringArray(R.array.unit_length),
            "weight" to resources.getStringArray(R.array.unit_weight),
            "temperature" to resources.getStringArray(R.array.unit_temperature),
            "volume" to resources.getStringArray(R.array.unit_volume),
            "time" to resources.getStringArray(R.array.unit_time)
        )
        //erstellt einen ArrayAdapter
        val unitAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item,resources.getStringArray(R.array.units))
        //Die Liste von Elementen wird aus den String-Arrays extrahiert, die in einer Ressourcendatei namens units definiert sind
        unitAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.unitSpinner.adapter = unitAdapter


        binding.unitSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                selectedUnit = parent.getItemAtPosition(position).toString()
                val selectedUnitArray = units[selectedUnit]
                val selectedAdapter = ArrayAdapter(this@Task2, android.R.layout.simple_spinner_item, selectedUnitArray!!)
                selectedAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                binding.spinnerFrom.adapter = selectedAdapter
                binding.spinnerTo.adapter = selectedAdapter
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Do nothing
            }
        }

        binding.spinnerFrom.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                fromUnit = parent.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Do nothing
            }
        }

        binding.spinnerTo.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                toUnit = parent.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Do nothing
            }
        }


            binding.convertButton.setOnClickListener {
                val inputValue: Double = (binding.inputField.text.toString()).toDouble()
                if (fromUnit == toUnit)
                    //binding.outputField.text = inputValue.toString()
                    binding.outputField.setText(inputValue.toString())
                else {
                    var outputValue = 0.0
                    when (selectedUnit) {
                        "length" -> outputValue = convertLength(inputValue)
                        "weight" -> outputValue = convertWeight(inputValue)
                        "temperature" -> outputValue = convertTemperature(inputValue)
                        "volume" -> outputValue = convertVolume(inputValue)
                        "time" -> outputValue = convertTime(inputValue)
                    }
                    binding.outputField.setText(outputValue.toString())
                }
            }
    }


    private fun convertLength(length:Double):Double{
        var value = length
        when (fromUnit) {
            "kilometer" -> {
                when (toUnit) {
                    "meter" -> value *= 1000
                    "centimeter" -> value *= 100000
                    "millimeter" -> value *= 1000000
                    "nautical mile" -> value *= 0.539956803
                    "mile" -> value *= 0.621371192
                    "yard" -> value *= 1093.6133
                    "feet" -> value *= 3280.8399
                    "inch" -> value *= 39370.0787
                }
            }
            "meter" -> {
                when (toUnit) {
                    "kilometer" -> value /= 1000
                    "centimeter" -> value *= 100
                    "millimeter" -> value *= 1000
                    "nautical mile" -> value *= 0.000539956803
                    "mile" -> value *= 0.000621371192
                    "yard" -> value *= 1.0936133
                    "feet" -> value *= 3.2808399
                    "inch" -> value *= 39.3700787
                }
            }
            "centimeter" -> {
                when (toUnit) {
                    "kilometer" -> value /= 100000
                    "meter" -> value /= 100
                    "millimeter" -> value *= 10
                    "nautical mile" -> value *= 0.00000539956803
                    "mile" -> value *= 0.00000621371192
                    "yard" -> value *= 0.010936133
                    "feet" -> value *= 0.032808399
                    "inch" -> value *= 0.393700787
                }
            }
            "millimeter" -> {
                when (toUnit) {
                    "kilometer" -> value /= 1000000
                    "meter" -> value /= 1000
                    "centimeter" -> value /= 10
                    "nautical mile" -> value *= 0.000000539956803
                    "mile" -> value *= 0.000000621371192
                    "yard" -> value *= 0.0010936133
                    "feet" -> value *= 0.0032808399
                    "inch" -> value *= 0.0393700787
                }
            }
            "nautical mile" -> {
                when (toUnit) {
                    "kilometer" -> value /= 0.539956803
                    "meter" -> value /= 0.000539956803
                    "centimeter" -> value /= 0.00000539956803
                    "millimeter" -> value /= 0.000000539956803
                    "mile" -> value *= 1.15077945
                    "yard" -> value *= 2025.37183
                    "feet" -> value *= 6076.11549
                    "inch" -> value *= 72913.3858
                }
            }
            "mile" -> {
                when (toUnit) {
                    "kilometer" -> value /= 0.621371192
                    "meter" -> value /= 0.000621371192
                    "centimeter" -> value /= 0.00000621371192
                    "millimeter" -> value /= 0.000000621371192
                    "nautical mile" -> value /= 1.15077945
                    "yard" -> value *= 1760.0
                    "feet" -> value *= 5280.0
                    "inch" -> value *= 63360.0
                }
            }
            "yard" -> {
                when (toUnit) {
                    "kilometer" -> value /= 1093.6133
                    "meter" -> value /= 1.0936133
                    "centimeter" -> value *= 91.44
                    "millimeter" -> value *= 914.4
                    "nautical mile" -> value /= 2025.37183
                    "mile" -> value /= 1760.0
                    "feet" -> value *= 3.0
                    "inch" -> value *= 36.0
                }
            }
            "feet" -> {
                when (toUnit) {
                    "kilometer" -> value /= 3280.8399
                    "meter" -> value /= 3.2808399
                    "centimeter" -> value *= 30.48
                    "millimeter" -> value *= 304.8
                    "nautical mile" -> value /= 6076.11549
                    "mile" -> value /= 5280.0
                    "yard" -> value /= 3.0
                    "inch" -> value *= 12.0
                }
            }
            "inch" -> {
                when (toUnit) {
                    "kilometer" -> value /= 39370.0787
                    "meter" -> value /= 39.3700787
                    "centimeter" -> value /= 0.393700787
                    "millimeter" -> value /= 0.0393700787
                    "nautical mile" -> value /= 72913.3858
                    "mile" -> value /= 63360.0
                    "yard" -> value /= 36.0
                    "feet" -> value /= 12.0
                }
            }
        }
        return value
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