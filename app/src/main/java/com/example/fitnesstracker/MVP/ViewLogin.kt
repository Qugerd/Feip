package com.example.fitnesstracker.MVP

interface ViewLogin {

    fun showLoginError()

    fun showPasswordError()

    fun showToast(message: String)
}