package com.vanarsdale.makinganav

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class CourseCompletionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_course_completion, container, false)

        val spinnerCourse = view.findViewById<Spinner>(R.id.spinner_course)
        val spinnerSemester = view.findViewById<Spinner>(R.id.spinner_semester)
        val btnAdd = view.findViewById<Button>(R.id.btn_add_course_completion)
        val courseListLayout = view.findViewById<LinearLayout>(R.id.completed_courses_list)

        // Sample data for spinners
        val courses = arrayOf("Select Course", "MAT 101", "MAT 102", "CSC 101", "CSC 102", "ENG 101")
        val semesters = arrayOf("Select Semester", "Fall 2023", "Spring 2024", "Fall 2024", "Spring 2025")

        val courseAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, courses)
        courseAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCourse.adapter = courseAdapter

        val semesterAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, semesters)
        semesterAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerSemester.adapter = semesterAdapter

        // Add a pre-loaded example
        addCourseItem("MAT 101", "Fall 2023", courseListLayout)

        btnAdd.setOnClickListener {
            val selectedCourse = spinnerCourse.selectedItem.toString()
            val selectedSemester = spinnerSemester.selectedItem.toString()

            if (selectedCourse == "Select Course" || selectedSemester == "Select Semester") {
                return@setOnClickListener
            }

            addCourseItem(selectedCourse, selectedSemester, courseListLayout)

            // Clear/Reset dropdowns
            spinnerCourse.setSelection(0)
            spinnerSemester.setSelection(0)
        }

        // Navigation from skeleton
        view.findViewById<ImageButton>(R.id.btn_flowchart)?.setOnClickListener {
            findNavController().navigate(R.id.action_CourseCompletion_to_ClassLayout)
        }

        return view
    }

    private fun addCourseItem(courseName: String, semester: String, container: LinearLayout) {
        // Remove the "No courses added yet" placeholder if present
        if (container.childCount == 1 && (container.getChildAt(0) as? TextView)?.text == "No courses added yet.") {
            container.removeAllViews()
        }

        val itemView = layoutInflater.inflate(R.layout.item_course_completion, container, false)
        
        itemView.findViewById<TextView>(R.id.tv_course_name).text = courseName
        itemView.findViewById<TextView>(R.id.tv_semester).text = semester
        
        itemView.findViewById<ImageButton>(R.id.btn_delete_course).setOnClickListener {
            container.removeView(itemView)
            
            // If the list is empty, show the placeholder again
            if (container.childCount == 0) {
                val placeholder = TextView(requireContext()).apply {
                    text = "No courses added yet."
                    textAlignment = View.TEXT_ALIGNMENT_CENTER
                    setPadding(0, 32, 0, 32)
                    setTextColor(resources.getColor(R.color.dark_gray, null))
                }
                container.addView(placeholder)
            }
        }
        
        container.addView(itemView)
    }
}
