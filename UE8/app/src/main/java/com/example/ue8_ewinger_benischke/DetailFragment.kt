package com.example.ue8_ewinger_benischke

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController

class DetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_detail, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val stringArray = arguments?.getStringArray("fruits")

        val title = view.findViewById<TextView>(R.id.titleTextView)
        title.text = stringArray?.get(1)

        val description = view.findViewById<TextView>(R.id.contentTextView)
        description.text = stringArray?.get(2)

        //Edit Fragment
        view.findViewById<Button>(R.id.navigate_to_edit_btn).setOnClickListener {
            val bundle = bundleOf("fruits" to stringArray)
            findNavController().navigate(R.id.action_detailFragment_to_editFragment,bundle)
        }

        //Home Fragment
        view.findViewById<Button>(R.id.navigate_back_to_home_btn).setOnClickListener {
            val bundle = bundleOf("fruits" to stringArray)
            findNavController().navigate(R.id.action_detailFragment_to_homeFragment,bundle)
        }
    }
}