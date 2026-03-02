package com.vanarsdale.makinganav

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RadioGroup
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class TransferInfoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_transfer_info, container, false)

        val domesticContainer = view.findViewById<LinearLayout>(R.id.domestic_info_container)
        val internationalContainer = view.findViewById<LinearLayout>(R.id.international_info_container)
        val radioGroup = view.findViewById<RadioGroup>(R.id.rg_transfer_type)

        // Conditional UI: Toggle Domestic/International Sections
        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.rb_domestic -> {
                    domesticContainer.visibility = View.VISIBLE
                    internationalContainer.visibility = View.GONE
                }
                R.id.rb_international -> {
                    domesticContainer.visibility = View.GONE
                    internationalContainer.visibility = View.VISIBLE
                }
            }
        }

        // Setup State Spinner for Domestic
        val spinnerState = view.findViewById<Spinner>(R.id.spinner_state)
        val states = arrayOf("Florida", "New York", "California", "Texas", "Other")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, states)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerState.adapter = adapter

        view.findViewById<Button>(R.id.btn_save_transfer_info).setOnClickListener {
            findNavController().popBackStack()
        }

        return view
    }
}