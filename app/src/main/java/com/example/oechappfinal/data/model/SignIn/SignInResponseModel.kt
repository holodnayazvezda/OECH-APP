package com.example.oechappfinal.data.model.SignIn

import com.google.gson.annotations.SerializedName

data class SignInResponseModel(
    @SerializedName("message") val message: String? = null,
    @SerializedName("token") val token: String? = null,
)
