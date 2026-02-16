package com.vanarsdale.makinganav

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageButton
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class TransferInfoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_transfer_info, container, false)

        val spinnerYear = view.findViewById<Spinner>(R.id.spinner_incoming_year)
        val years = arrayOf("2020", "2021", "2022", "2023", "2024", "2025")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, years)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerYear.adapter = adapter

        view.findViewById<Button>(R.id.btn_save_transfer_info).setOnClickListener {
            // Placeholder for save logic
            findNavController().popBackStack()
        }

        // Navigation from skeleton
        view.findViewById<ImageButton>(R.id.btn_flowchart)?.setOnClickListener {
            findNavController().navigate(R.id.action_TransferInfo_to_ClassLayout)
        }
        view.findViewById<ImageButton>(R.id.btn_advisor)?.setOnClickListener {
            findNavController().navigate(R.id.action_TransferInfo_to_AdvisingInfo)
        }
        view.findViewById<ImageButton>(R.id.btn_help)?.setOnClickListener {
            findNavController().navigate(R.id.action_TransferInfo_to_how_To_Use)
        }
        view.findViewById<ImageButton>(R.id.btn_faq)?.setOnClickListener {
            findNavController().navigate(R.id.action_TransferInfo_to_FAQ_Resources)
        }
        view.findViewById<ImageButton>(R.id.btn_profile)?.setOnClickListener {
            findNavController().navigate(R.id.action_TransferInfo_to_StudentProfile)
        }

        return view
    }
}
