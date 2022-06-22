package com.example.fitnesstracker.MVP

interface ViewProfile {

    fun showToast(message: String)

    fun getData(
        name: String,
        login: String
    )

}