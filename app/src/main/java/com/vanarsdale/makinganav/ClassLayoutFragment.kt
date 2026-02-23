package com.vanarsdale.makinganav

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.button.MaterialButtonToggleGroup

class ClassLayoutFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.class_layout, container, false)

        val toggleGroup = view.findViewById<MaterialButtonToggleGroup>(R.id.toggle_major_minor)

        // Setup navigation buttons from skeleton.xml
        view.findViewById<ImageButton>(R.id.btn_advisor)?.setOnClickListener {
            findNavController().navigate(R.id.action_ClassLayout_to_AdvisingInfo)
        }
        view.findViewById<ImageButton>(R.id.btn_help)?.setOnClickListener {
            findNavController().navigate(R.id.action_ClassLayout_to_how_To_Use)
        }
        view.findViewById<ImageButton>(R.id.btn_faq)?.setOnClickListener {
            findNavController().navigate(R.id.action_ClassLayout_to_FAQ_Resources)
        }

        return view
    }
}
