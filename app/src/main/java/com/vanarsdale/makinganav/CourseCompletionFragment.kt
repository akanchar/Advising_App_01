package com.vanarsdale.makinganav

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class CourseCompletionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_course_completion, container, false)

        val radioGroup = view.findViewById<RadioGroup>(R.id.rg_search_method)
        val searchLayout = view.findViewById<TextInputLayout>(R.id.search_layout)
        val manualEntryLayout = view.findViewById<LinearLayout>(R.id.manual_entry_container)
        val statusMessage = view.findViewById<TextView>(R.id.tv_status_message)
        
        val spinnerSemester = view.findViewById<Spinner>(R.id.spinner_semester)
        val btnAdd = view.findViewById<Button>(R.id.btn_add_course)
        val rvCompleted = view.findViewById<RecyclerView>(R.id.rv_completed_courses)

        // Conditional UI: Toggle between Search and Manual Entry
        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.rb_search -> {
                    searchLayout.visibility = View.VISIBLE
                    manualEntryLayout.visibility = View.GONE
                    statusMessage.text = "Using course catalog search"
                }
                R.id.rb_manual -> {
                    searchLayout.visibility = View.GONE
                    manualEntryLayout.visibility = View.VISIBLE
                    statusMessage.text = "Entering course details manually"
                }
            }
        }

        // Setup Semester Spinner
        val semesters = arrayOf("Select Semester", "Fall 2023", "Spring 2024", "Fall 2024", "Spring 2025")
        val semesterAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, semesters)
        semesterAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerSemester.adapter = semesterAdapter

        rvCompleted.layoutManager = LinearLayoutManager(requireContext())

        // Navigation from skeleton
        view.findViewById<ImageButton>(R.id.btn_flowchart)?.setOnClickListener {
            findNavController().navigate(R.id.action_CourseCompletion_to_ClassLayout)
        }
        
        view.findViewById<ImageButton>(R.id.btn_profile)?.setOnClickListener {
            findNavController().navigate(R.id.StudentProfile)
        }

        view.findViewById<Button>(R.id.btn_back_to_class_layout).setOnClickListener {
            findNavController().popBackStack()
        }

        return view
    }
}