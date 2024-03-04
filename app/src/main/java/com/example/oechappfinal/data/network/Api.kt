package com.example.oechappfinal.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://prof-01o2.onrender.com/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

object Api {
    val RetrofitService : ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}