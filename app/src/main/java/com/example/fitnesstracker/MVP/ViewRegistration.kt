package com.example.fitnesstracker.MVP

interface ViewRegistration {

    fun showLoginError()

    fun showPasswordError()

    fun showNameError()

    fun showToast(message: String)
}