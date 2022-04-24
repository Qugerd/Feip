package com.example.fitnesstracker

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class WelcomePage: Fragment(R.layout.activity_welcome_page) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.btn_registration).setOnClickListener {
            findNavController().navigate(R.id.action_welcomePage_to_registrationPage)
        }

        view.findViewById<TextView>(R.id.have_account).setOnClickListener {
            findNavController().navigate(R.id.action_welcomePage_to_login)
        }
    }
}