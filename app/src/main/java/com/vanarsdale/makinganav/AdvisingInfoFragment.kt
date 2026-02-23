package com.vanarsdale.makinganav

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.navigation.fragment.findNavController

class AdvisingInfoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_advising_info, container, false)

        // Contact Advisor Email Button
        view.findViewById<Button>(R.id.btn_contact_advisor)?.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:jsmith@ut.edu")
                putExtra(Intent.EXTRA_SUBJECT, "Advising Inquiry")
            }
            startActivity(Intent.createChooser(emailIntent, "Send email..."))
        }

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

        return view
    }
}
