package com.example.fitnesstracker.DTO

import com.google.gson.annotations.SerializedName

data class UserDTO (

    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("login")
    val login: String,
    @SerializedName("gender")
    val gender: GenderDTO

)