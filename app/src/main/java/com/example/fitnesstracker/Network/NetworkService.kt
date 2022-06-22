package com.example.fitnesstracker.Network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkService {

    private val logger = HttpLoggingInterceptor()

    private val httpClient =
        OkHttpClient.Builder()
            .addInterceptor(logger.setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://fefu.t.feip.co/")
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}

