package com.example.oechappfinal.data.model.SignUp

import com.google.gson.annotations.SerializedName

data class SignUpRequestModel(
    @SerializedName("name") val name: String? = null,
    @SerializedName("phone") val phone: String? = null,
    @SerializedName("email") val email: String? = null,
    @SerializedName("password") val password: String? = null,
)
