package com.vanarsdale.makinganav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

class StudentProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.studentprofile, container, false)

        val advisorButton = view.findViewById<Button>(R.id.login3)
        advisorButton.isEnabled = true // Ensure it's clickable
        advisorButton.setOnClickListener {
            findNavController().navigate(R.id.action_StudentProfile_to_AdvisingInfo)
        }

        return view
    }
}