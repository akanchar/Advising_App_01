package com.vanarsdale.makinganav

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.vanarsdale.makinganav.databinding.FragmentCourseCompletionBinding

class CourseCompletionFragment : Fragment() {

    private var _binding: FragmentCourseCompletionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCourseCompletionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setup Semester Spinner
        val semesters = arrayOf("Select Semester", "Fall 2023", "Spring 2024", "Fall 2024", "Spring 2025")
        val semesterAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, semesters)
        semesterAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerSemester.adapter = semesterAdapter

        // Setup Completed Courses RecyclerView
        binding.rvCompletedCourses.layoutManager = LinearLayoutManager(requireContext())

        binding.btnAddCourse.setOnClickListener {
            val courseSearch = binding.etCourseSearch.text.toString()
            val selectedSemester = binding.spinnerSemester.selectedItem.toString()

            if (courseSearch.isEmpty() || selectedSemester == "Select Semester") {
                return@setOnClickListener
            }

            // Logic to add the course would go here
            binding.etCourseSearch.text?.clear()
            binding.spinnerSemester.setSelection(0)
        }

        // Navigation for "Back to Class Layout" button
        binding.btnBackToClassLayout.setOnClickListener {
            // This uses the action defined in your nav.xml
            findNavController().navigate(R.id.action_CourseCompletion_to_ClassLayout)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
