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
import com.google.android.material.textfield.TextInputEditText

class CourseCompletionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_course_completion, container, false)

        val etCourseSearch = view.findViewById<TextInputEditText>(R.id.et_course_search)
        val spinnerSemester = view.findViewById<Spinner>(R.id.spinner_semester)
        val btnAddCourse = view.findViewById<Button>(R.id.btn_add_course)

        // Sample data for semester spinner
        val semesters = arrayOf("Select Semester", "Fall 2023", "Spring 2024", "Fall 2024", "Spring 2025")
        val semesterAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, semesters)
        semesterAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerSemester.adapter = semesterAdapter

        btnAddCourse.setOnClickListener {
            val courseSearch = etCourseSearch.text.toString()
            val selectedSemester = spinnerSemester.selectedItem.toString()

            if (courseSearch.isEmpty() || selectedSemester == "Select Semester") {
                // TODO: Show error message
                return@setOnClickListener
            }

            // TODO: Implement logic to add course to the completed list (RecyclerView)
            
            // Clear inputs
            etCourseSearch.setText("")
            spinnerSemester.setSelection(0)
        }

        // Navigation from skeleton
        view.findViewById<ImageButton>(R.id.btn_flowchart)?.setOnClickListener {
            findNavController().navigate(R.id.action_CourseCompletion_to_ClassLayout)
        }
        view.findViewById<ImageButton>(R.id.btn_advisor)?.setOnClickListener {
            findNavController().navigate(R.id.action_CourseCompletion_to_AdvisingInfo)
        }
        view.findViewById<ImageButton>(R.id.btn_help)?.setOnClickListener {
            findNavController().navigate(R.id.action_CourseCompletion_to_how_To_Use)
        }
        view.findViewById<ImageButton>(R.id.btn_faq)?.setOnClickListener {
            findNavController().navigate(R.id.action_CourseCompletion_to_FAQ_Resources)
        }
        view.findViewById<ImageButton>(R.id.btn_profile)?.setOnClickListener {
            findNavController().navigate(R.id.action_CourseCompletion_to_StudentOnboarding)
        }

        return view
    }
}
