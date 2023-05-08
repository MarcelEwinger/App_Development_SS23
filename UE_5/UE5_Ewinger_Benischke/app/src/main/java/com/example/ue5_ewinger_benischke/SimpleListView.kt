package com.example.ue5_ewinger_benischke

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SimpleListView : AppCompatActivity() {
    private lateinit var listView: ListView
    private lateinit var items: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_list_view)

        listView = findViewById(R.id.list_view)
        items = arrayOf("Apfel", "Banane", "Orange", "Kiwi", "Mango", "Ananas",
            "Erdbeere", "Himbeere", "Heidelbeere", "Kirsche", "Pfirsich",
            "Nektarine", "Maracuja", "Passionsfrucht", "Birne", "Traube",
            "Zitrone", "Limette", "Grapefruit", "Melone", "Wassermelone",
            "Guave", "Feige", "Granatapfel", "Kaki", "Litschi", "Maulbeere",
            "Papaya", "Quitte", "Rhabarber")

        //ArrayAdapter Objekt
        val adapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1, items)

        //connect adapter to listView
        listView.adapter = adapter

        listView.setOnItemClickListener { parent, view, position, id ->
            val selectedItem = items[position]
            Toast.makeText(this, selectedItem, Toast.LENGTH_SHORT).show()
        }
    }
}