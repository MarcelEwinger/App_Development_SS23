package com.example.ue8_ewinger_benischke

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.navigation.fragment.findNavController

class HomeFragment : Fragment() {
    private lateinit var listView: ListView
    private lateinit var items: Array<String>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?):
            View? = inflater.inflate(R.layout.fragment_home, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listView = view.findViewById(R.id.list_view)
        items = arrayOf("Apfel", "Banane", "Orange", "Kiwi", "Mango", "Ananas",
            "Erdbeere", "Himbeere", "Heidelbeere", "Kirsche", "Pfirsich",
            "Nektarine", "Maracuja", "Passionsfrucht", "Birne", "Traube",
            "Zitrone", "Limette", "Grapefruit", "Melone", "Wassermelone",
            "Guave", "Feige", "Granatapfel", "Kaki", "Litschi", "Maulbeere",
            "Papaya", "Quitte", "Rhabarber")

        val adapter = ArrayAdapter(requireContext(),android.R.layout.simple_list_item_1,items)

        listView.adapter = adapter

        listView.setOnItemClickListener { parent, view, position, id ->
            findNavController().navigate(R.id.action_homeFragment_to_detailFragment)
        }
    }
}