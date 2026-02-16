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

        val header = view.findViewById<TextView>(R.id.major_header)
        val imageView = view.findViewById<ImageView>(R.id.imageViewFlowchart)
        val toggleGroup = view.findViewById<MaterialButtonToggleGroup>(R.id.toggle_major_minor)

        toggleGroup.addOnButtonCheckedListener { _, checkedId, isChecked ->
            if (isChecked) {
                when (checkedId) {
                    R.id.btn_select_major -> {
                        header.text = getString(R.string.math_major_flowchart_title)
                        imageView.setImageResource(R.drawable.mathclas)
                    }
                    R.id.btn_select_minor -> {
                        header.text = "Math Minor Requirements"
                        // Placeholder: in a real app, you'd have a separate image for the minor
                        imageView.setImageResource(R.drawable.mathclas) 
                        imageView.alpha = 0.5f // Visual indicator it's different/placeholder
                    }
                }
            }
        }

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
        view.findViewById<ImageButton>(R.id.btn_profile)?.setOnClickListener {
            findNavController().navigate(R.id.action_ClassLayout_to_StudentProfile)
        }

        return view
    }
}
