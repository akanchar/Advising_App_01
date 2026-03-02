package com.vanarsdale.makinganav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.vanarsdale.makinganav.databinding.FragmentStudentprofileBinding

class StudentProfileFragment : Fragment() {

    private var _binding: FragmentStudentprofileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStudentprofileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSaveProfile.setOnClickListener {
            // Here you would typically save the profile data to a database or ViewModel
            Toast.makeText(context, "Profile Saved Successfully", Toast.LENGTH_SHORT).show()

            // Use Navigation Component to navigate to the Progress Area
            findNavController().navigate(R.id.action_StudentProfile_to_progressAreaFragment2)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
