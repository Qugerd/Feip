package com.example.fitnesstracker.DTO

import com.google.gson.annotations.SerializedName

data class GenderDTO (

    @SerializedName("code")
    val code: Int,
    @SerializedName("name")
    val name: String

)