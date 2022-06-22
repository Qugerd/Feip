package com.example.fitnesstracker

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.fitnesstracker.MVP.PresenterProfile
import com.example.fitnesstracker.MVP.ViewProfile

class PageProfile: Fragment(R.layout.activity_fragment_profile), ViewProfile {

    private val presenter = PresenterProfile()
    private var navController: NavController? = null

    private val sharedPrefs by lazy {
        requireContext().getSharedPreferences("Tokens", Context.MODE_PRIVATE)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        navController = parentFragment?.parentFragment?.findNavController()

        presenter.attachView(this)

        presenter.onViewCreated(sharedPrefs.getString("Token", "").toString())

        view.findViewById<Button>(R.id.logoutButton).setOnClickListener {
            presenter.onLogoutClicked(sharedPrefs.getString("Token", "").toString())
            presenter.deleteToken(sharedPrefs, navController!!)
        }

    }

    override fun onDestroyView() {
        presenter.detachView()
        super.onDestroyView()
    }

    override fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    override fun getData(name: String, login: String) {
        view?.findViewById<TextView>(R.id.name)?.text = name
        view?.findViewById<TextView>(R.id.login)?.text = login
    }
}