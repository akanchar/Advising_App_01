package com.vanarsdale.makinganav

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageButton
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText

class CourseCompletionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_course_completion, container, false)

        val etSearch = view.findViewById<TextInputEditText>(R.id.et_course_search)
        val spinnerSemester = view.findViewById<Spinner>(R.id.spinner_semester)
        val btnAdd = view.findViewById<Button>(R.id.btn_add_course)
        val rvCompleted = view.findViewById<RecyclerView>(R.id.rv_completed_courses)

        // Setup Semester Spinner
        val semesters = arrayOf("Select Semester", "Fall 2023", "Spring 2024", "Fall 2024", "Spring 2025")
        val semesterAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, semesters)
        semesterAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerSemester.adapter = semesterAdapter

        // Setup Completed Courses RecyclerView
        rvCompleted.layoutManager = LinearLayoutManager(requireContext())
        // Note: You would typically set an adapter here for the RecyclerView

        btnAdd.setOnClickListener {
            val courseSearch = etSearch.text.toString()
            val selectedSemester = spinnerSemester.selectedItem.toString()

            if (courseSearch.isEmpty() || selectedSemester == "Select Semester") {
                // Handle error or toast
                return@setOnClickListener
            }

            // Logic to add the course would go here
            etSearch.text?.clear()
            spinnerSemester.setSelection(0)
        }

        // Navigation from skeleton
        view.findViewById<ImageButton>(R.id.btn_flowchart)?.setOnClickListener {
            findNavController().navigate(R.id.action_CourseCompletion_to_ClassLayout)
        }
        
        view.findViewById<ImageButton>(R.id.btn_profile)?.setOnClickListener {
            findNavController().navigate(R.id.StudentProfile)
        }

        return view
    }
}
