package com.vanarsdale.makinganav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.appcompat.widget.SwitchCompat
import androidx.navigation.fragment.findNavController

class StudentProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_studentprofile, container, false)

        // Handle Transfer Student Switch
        val transferSwitch = view.findViewById<SwitchCompat>(R.id.switch_transfer)
        transferSwitch?.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                findNavController().navigate(R.id.action_StudentProfile_to_TransferInfo)
            }
        }

        // The navigation buttons are part of the included skeleton.xml
        val advisorButton = view.findViewById<ImageButton>(R.id.btn_advisor)
        advisorButton?.setOnClickListener {
            findNavController().navigate(R.id.action_StudentProfile_to_AdvisingInfo)
        }

        val flowchartButton = view.findViewById<ImageButton>(R.id.btn_flowchart)
        flowchartButton?.setOnClickListener {
            findNavController().navigate(R.id.action_StudentProfile_to_ClassLayout)
        }

        val helpButton = view.findViewById<ImageButton>(R.id.btn_help)
        helpButton?.setOnClickListener {
            findNavController().navigate(R.id.action_StudentProfile_to_how_To_Use2)
        }

        val faqButton = view.findViewById<ImageButton>(R.id.btn_faq)
        faqButton?.setOnClickListener {
            findNavController().navigate(R.id.action_StudentProfile_to_FAQ_Resources2)
        }

        return view
    }
}
