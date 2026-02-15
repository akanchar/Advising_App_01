package com.vanarsdale.makinganav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class FAQ_Resources : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_f_a_q__resources, container, false)

        // Setup FAQ items
        setupCollapsibleItem(view, R.id.faq_header_1, R.id.faq_content_1, R.id.faq_arrow_1)
        setupCollapsibleItem(view, R.id.faq_header_2, R.id.faq_content_2, R.id.faq_arrow_2)
        setupCollapsibleItem(view, R.id.faq_header_3, R.id.faq_content_3, R.id.faq_arrow_3)

        // Setup Resources items
        setupCollapsibleItem(view, R.id.res_header_1, R.id.res_content_1, R.id.res_arrow_1)
        setupCollapsibleItem(view, R.id.res_header_2, R.id.res_content_2, R.id.res_arrow_2)
        setupCollapsibleItem(view, R.id.res_header_3, R.id.res_content_3, R.id.res_arrow_3)

        return view
    }

    private fun setupCollapsibleItem(parent: View, headerId: Int, contentId: Int, arrowId: Int) {
        val header = parent.findViewById<LinearLayout>(headerId)
        val content = parent.findViewById<TextView>(contentId)
        val arrow = parent.findViewById<ImageView>(arrowId)

        header.setOnClickListener {
            if (content.visibility == View.GONE) {
                content.visibility = View.VISIBLE
                arrow.animate().rotation(180f).setDuration(200).start()
            } else {
                content.visibility = View.GONE
                arrow.animate().rotation(0f).setDuration(200).start()
            }
        }
    }
}