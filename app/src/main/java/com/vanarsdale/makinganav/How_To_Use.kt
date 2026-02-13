package com.vanarsdale.makinganav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

class How_To_Use : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_how__to__use, container, false)

        // Find the back button and set up navigation to return to the previous screen
        val backButton = view.findViewById<Button>(R.id.btn_back)
        backButton.setOnClickListener {
            // Using navigation controller to navigate back
            findNavController().navigateUp()
        }

        return view
    }
}