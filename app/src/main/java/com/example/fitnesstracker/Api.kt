package com.example.fitnesstracker


import com.example.fitnesstracker.DTO.RegisterDTO
import com.example.fitnesstracker.DTO.UserDTO
import retrofit2.http.GET
import retrofit2.http.*
import retrofit2.Call

interface Api {

    @POST("/api/auth/register")
    fun register(
        @Query("login") login: String,
        @Query("password") password: String,
        @Query("name") name: String,
        @Query("gender") gender: Int
    ): Call<RegisterDTO>

    @POST("/api/auth/login")
    fun login(
        @Query("login") login: String,
        @Query("password") password: String
    ): Call<RegisterDTO>

    @POST("/api/auth/logout")
    fun logout(
        @Header("Authorization") token: String
    ): Call<Any>

    @GET("/api/user/profile")
    fun profile(
        @Header("Authorization") token: String
    ): Call<UserDTO>
}