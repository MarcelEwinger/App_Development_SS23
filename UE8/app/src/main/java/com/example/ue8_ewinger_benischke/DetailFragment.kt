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
import androidx.navigation.fragment.navArgs

class DetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_detail, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val position = arguments?.getInt("position")

        val title = view.findViewById<TextView>(R.id.titleTextView)
        title.text = arguments?.getString("name")

        val description = view.findViewById<TextView>(R.id.contentTextView)
        description.text = arguments?.getString("description")

        //Edit Fragment
        view.findViewById<Button>(R.id.navigate_to_edit_btn).setOnClickListener {
            val action = position?.let { it1 ->
                DetailFragmentDirections.actionDetailFragmentToEditFragment(
                    it1,title.text.toString(),description.text.toString())
            }
            if (action != null) {
                findNavController().navigate(action)
            }
        }

        //Home Fragment
        view.findViewById<Button>(R.id.navigate_back_to_home_btn).setOnClickListener {
            val action = position?.let { it1 ->
                DetailFragmentDirections.actionDetailFragmentToHomeFragment(
                    it1,title.text.toString(),description.text.toString())
            }
            if (action != null) {
                findNavController().navigate(action)
            }
        }
    }
}