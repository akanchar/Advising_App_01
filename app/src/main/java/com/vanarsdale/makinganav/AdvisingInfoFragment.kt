package com.vanarsdale.makinganav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.navigation.fragment.findNavController

class AdvisingInfoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_advising_info, container, false)

        // Setup navigation buttons from skeleton.xml
        view.findViewById<ImageButton>(R.id.btn_flowchart)?.setOnClickListener {
            findNavController().navigate(R.id.action_AdvisingInfo_to_ClassLayout)
        }

        view.findViewById<ImageButton>(R.id.btn_help)?.setOnClickListener {
            findNavController().navigate(R.id.action_AdvisingInfo_to_how_To_Use)
        }

        view.findViewById<ImageButton>(R.id.btn_faq)?.setOnClickListener {
            findNavController().navigate(R.id.action_AdvisingInfo_to_FAQ_Resources)
        }

        view.findViewById<ImageButton>(R.id.btn_profile)?.setOnClickListener {
            findNavController().navigate(R.id.action_AdvisingInfo_to_StudentProfile)
        }

        return view
    }
}
