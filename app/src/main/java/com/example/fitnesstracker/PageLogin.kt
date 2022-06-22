package com.example.fitnesstracker

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.fitnesstracker.MVP.PresenterLogin
import com.example.fitnesstracker.MVP.ViewLogin
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class PageLogin : Fragment(R.layout.fragment_login), ViewLogin {

    private val presenter = PresenterLogin()

    private val sharedPrefs by lazy {
        requireContext().getSharedPreferences("Tokens", Context.MODE_PRIVATE)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.attachView(this)
        presenter.setNavController(findNavController())

        view.findViewById<Toolbar>(R.id.toolbar_login).setNavigationOnClickListener {
            findNavController().navigateUp()
        }

        view.findViewById<Button>(R.id.btn_login).setOnClickListener {
            presenter.onLoginClicked(
                view.findViewById<TextInputEditText>(R.id.loginInput).text.toString(),
                view.findViewById<TextInputEditText>(R.id.passwordInput).text.toString(),
                sharedPrefs)
        }
    }

    override fun onDestroyView() {
        presenter.detachView()
        super.onDestroyView()
    }

    override fun showLoginError() {
        view?.findViewById<TextInputLayout>(R.id.login)?.error = "Введите логин"
    }

    override fun showPasswordError() {
        view?.findViewById<TextInputLayout>(R.id.password)?.error = "Введите пароль"
    }

    override fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}