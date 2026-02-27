package com.vanarsdale.makinganav

import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        // Listen for destination changes to re-bind the buttons in the skeleton layout
        // since the skeleton is included in individual fragment layouts.
        navController.addOnDestinationChangedListener { _, _, _ ->
            setupBottomNavButtons()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_container)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun setupBottomNavButtons() {
        findViewById<ImageButton>(R.id.btn_flowchart)?.setOnClickListener {
            navController.navigate(R.id.action_global_ClassLayout)
        }
        findViewById<ImageButton>(R.id.btn_advisor)?.setOnClickListener {
            navController.navigate(R.id.action_global_AdvisingInfo)
        }
        findViewById<ImageButton>(R.id.btn_profile)?.setOnClickListener {
            navController.navigate(R.id.action_global_StudentProfile)
        }
        findViewById<ImageButton>(R.id.btn_help)?.setOnClickListener {
            navController.navigate(R.id.action_global_how_To_Use)
        }
        findViewById<ImageButton>(R.id.btn_faq)?.setOnClickListener {
            navController.navigate(R.id.action_global_FAQ_Resources)
        }
    }
}
