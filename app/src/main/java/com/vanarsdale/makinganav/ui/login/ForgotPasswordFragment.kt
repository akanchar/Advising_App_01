package com.vanarsdale.makinganav.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.vanarsdale.makinganav.R

class ForgotPasswordFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_forgot_password, container, false)

        val resetButton = view.findViewById<Button>(R.id.btn_reset_password)
        val backToLoginButton = view.findViewById<Button>(R.id.btn_back_to_login)

        resetButton.setOnClickListener {
            // Placeholder for reset logic
            Toast.makeText(context, "Reset instructions sent if email exists", Toast.LENGTH_SHORT).show()
        }

        backToLoginButton.setOnClickListener {
            findNavController().popBackStack()
        }

        return view
    }
}
