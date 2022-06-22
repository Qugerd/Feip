package com.example.fitnesstracker

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class ActivityFragment: Fragment(R.layout.fragment_activity)  {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bottomNavView = view.findViewById<BottomNavigationView>(R.id.bottomNav)
        val navController = (childFragmentManager.findFragmentById(R.id.activityContainerView) as NavHostFragment).navController

        bottomNavView.setupWithNavController(navController)
    }
}