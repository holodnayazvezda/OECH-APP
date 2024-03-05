package com.example.oechappfinal.data.model.Balance

import com.google.gson.annotations.SerializedName

data class BalanceResponseModel(
    @SerializedName("balance") val balance: Int? = null
)
