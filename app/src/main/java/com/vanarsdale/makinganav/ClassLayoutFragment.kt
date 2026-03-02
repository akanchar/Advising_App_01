package com.vanarsdale.makinganav

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.vanarsdale.makinganav.databinding.ClassLayoutBinding

class ClassLayoutFragment : Fragment() {

    private var _binding: ClassLayoutBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ClassLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setup the "Edit Courses" button to use the Navigation Component
        binding.btnEditCourses.setOnClickListener {
            // This uses the action defined in your nav.xml
            findNavController().navigate(R.id.action_ClassLayout_to_CourseCompletion)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
