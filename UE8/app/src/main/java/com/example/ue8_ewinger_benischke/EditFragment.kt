package com.example.ue8_ewinger_benischke

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController

class EditFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_edit, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val stringArray = arguments?.getStringArray("fruits")


        val editTitle = view.findViewById<EditText>(R.id.editTitle)
        editTitle.text = Editable.Factory.getInstance().newEditable(stringArray?.get(1))

        val editDescription = view.findViewById<EditText>(R.id.editText)
        editDescription.text = Editable.Factory.getInstance().newEditable(stringArray?.get(2))

        view.findViewById<Button>(R.id.navigate_back_to_detail_btn).setOnClickListener {
            val data = arrayOf(stringArray?.get(0),editTitle.text.toString(),editDescription.text.toString())
            val bundle = bundleOf("fruits" to data)
            findNavController().navigate(R.id.action_editFragment_to_detailFragment,bundle)
        }
    }
}