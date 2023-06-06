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
    private lateinit var fruits: Array<String>
    private lateinit var fruitDesc: Array<String>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?):
            View? = inflater.inflate(R.layout.fragment_home, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listView = view.findViewById(R.id.list_view)
        fruits = arrayOf("Apfel", "Banane", "Orange", "Kiwi", "Mango", "Ananas",
            "Erdbeere", "Himbeere", "Heidelbeere", "Kirsche", "Pfirsich",
            "Nektarine", "Maracuja", "Passionsfrucht", "Birne", "Traube",
            "Zitrone", "Limette", "Grapefruit", "Melone", "Wassermelone",
            "Guave", "Feige", "Granatapfel", "Kaki", "Litschi", "Maulbeere",
            "Papaya", "Quitte", "Rhabarber")

        fruitDesc = arrayOf(
            "Der Apfel ist eine knackige und saftige Frucht.",
            "Die Banane ist eine leckere und energiereiche Frucht.",
            "Die Orange ist eine zitrusartige und erfrischende Frucht.",
            "Die Kiwi ist eine exotische und vitaminreiche Frucht.",
            "Die Mango ist eine süße und tropische Frucht.",
            "Die Ananas ist eine saftige und aromatische Frucht.",
            "Die Erdbeere ist eine köstliche und aromatische Frucht.",
            "Die Himbeere ist eine kleine und saftige Beerenfrucht.",
            "Die Heidelbeere ist eine blaue und antioxidative Beerenfrucht.",
            "Die Kirsche ist eine süße und saftige Steinfrucht.",
            "Der Pfirsich ist eine saftige und duftende Frucht.",
            "Die Nektarine ist eine süße und saftige Steinfrucht ähnlich der Pfirsich.",
            "Die Maracuja ist eine exotische und saftige Frucht mit intensivem Geschmack.",
            "Die Passionsfrucht ist eine tropische und aromatische Frucht.",
            "Die Birne ist eine knackige und süße Frucht.",
            "Die Traube ist eine saftige und süße Beerenfrucht.",
            "Die Zitrone ist eine saure und erfrischende Frucht.",
            "Die Limette ist eine saure und aromatische Frucht ähnlich der Zitrone.",
            "Die Grapefruit ist eine große und saftige Zitrusfrucht.",
            "Die Melone ist eine erfrischende und saftige Frucht mit viel Wasser.",
            "Die Wassermelone ist eine große und saftige Frucht mit viel süßem Fruchtfleisch.",
            "Die Guave ist eine duftende und exotische Frucht mit vielen kleinen Kernen.",
            "Die Feige ist eine süße und fleischige Frucht mit weicher Schale.",
            "Der Granatapfel ist eine antioxidative und kernreiche Frucht.",
            "Die Kaki ist eine süße und herbstliche Frucht.",
            "Die Litschi ist eine exotische und saftige Frucht mit ledriger Schale.",
            "Die Maulbeere ist eine kleine und süße Beerenfrucht.",
            "Die Papaya ist eine tropische und saftige Frucht mit orangefarbenem Fruchtfleisch.",
            "Die Quitte ist eine harte und aromatische Frucht.",
            "Der Rhabarber ist eine säuerliche und faserige Frucht, die meist als Gemüse verwendet wird."
        )


        val adapter = ArrayAdapter(requireContext(),android.R.layout.simple_list_item_1,fruits)

        listView.adapter = adapter
        
        fruits[arguments?.getInt("position")!!] = arguments?.getString("name").toString()
        fruitDesc[arguments?.getInt("position")!!] = arguments?.getString("description").toString()

        listView.setOnItemClickListener { parent, view, position, id ->
            val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(
                position,fruits[position],fruitDesc[position]
            )
            findNavController().navigate(action)
        }
    }
}