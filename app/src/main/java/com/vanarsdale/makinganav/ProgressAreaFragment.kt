package com.vanarsdale.makinganav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import android.widget.TextView
import com.google.android.material.card.MaterialCardView
import com.google.android.material.progressindicator.LinearProgressIndicator

class ProgressAreaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_progress_area, container, false)

        val planGroup = view.findViewById<RadioGroup>(R.id.rg_plan_type)
        val alertCard = view.findViewById<MaterialCardView>(R.id.accelerated_alert_card)
        val statusSummary = view.findViewById<TextView>(R.id.tv_status_summary)
        val progressMajor = view.findViewById<LinearProgressIndicator>(R.id.progress_major)
        val tvMajorCredits = view.findViewById<TextView>(R.id.tv_major_credits)

        // Conditional UI logic
        planGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.rb_standard -> {
                    alertCard.visibility = View.GONE
                    statusSummary.text = "Status: On track for Spring 2026 graduation."
                    progressMajor.progress = 75
                    tvMajorCredits.text = "75% Complete (45 / 60 Credits)"
                }
                R.id.rb_accelerated -> {
                    alertCard.visibility = View.VISIBLE
                    statusSummary.text = "Status: On track for Fall 2025 graduation!"
                    // Show different progress logic (maybe more credits needed for accelerated?)
                    progressMajor.progress = 60
                    tvMajorCredits.text = "60% Complete (45 / 75 Credits)"
                }
            }
        }

        return view
    }
}