package com.example.oechappfinal.data.model.SignIn

import com.google.gson.annotations.SerializedName

data class SignInRequestModel(
    @SerializedName("email") val email: String? = null,
    @SerializedName("password") val password: String? = null
)
