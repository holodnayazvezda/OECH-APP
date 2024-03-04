package com.example.oechappfinal.data.model.GetValidCode

import com.google.gson.annotations.SerializedName

data class GetValidCodeRequestModel(
    @SerializedName("email") val email: String? = null
)
