package com.example.oechappfinal.data.model.SignUp

import com.google.gson.annotations.SerializedName

data class SignUpResponseModel(
    @SerializedName("message") val message: String? = null,
    @SerializedName("token") val token: String? = null
)