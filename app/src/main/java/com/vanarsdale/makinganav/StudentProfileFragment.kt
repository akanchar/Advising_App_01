package com.vanarsdale.makinganav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.widget.SwitchCompat

class StudentProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_studentprofile, container, false)

        val transferSwitch = view.findViewById<SwitchCompat>(R.id.switch_transfer)
        val transferDetails = view.findViewById<LinearLayout>(R.id.transfer_details_container)
        
        val graduateSwitch = view.findViewById<SwitchCompat>(R.id.switch_graduate)
        val gradDetails = view.findViewById<LinearLayout>(R.id.grad_details_container)

        // Conditional UI: Toggle Transfer Details
        transferSwitch.setOnCheckedChangeListener { _, isChecked ->
            transferDetails.visibility = if (isChecked) View.VISIBLE else View.GONE
        }

        // Conditional UI: Toggle Graduate Details
        graduateSwitch.setOnCheckedChangeListener { _, isChecked ->
            gradDetails.visibility = if (isChecked) View.VISIBLE else View.GONE
        }

        return view
    }
}