package com.example.oechappfinal.ui.screen.otpverification

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.oechappfinal.data.model.GetValidCode.GetValidCodeRequestModel
import com.example.oechappfinal.data.network.Api
import com.example.oechappfinal.domain.usecase.OtpVerificationUsecase
import kotlinx.coroutines.launch

class OtpVerificationViewModel(private val otpVerificationUsecase: OtpVerificationUsecase) : ViewModel() {
    var otpVerificationData by mutableStateOf(OtpVerificationData())
        private set

    fun updateError(error: String?) {
        otpVerificationData = otpVerificationData.copy(error = error)
    }

    fun getValidCode() {
        otpVerificationData = otpVerificationData.copy(isLoading = true)
        viewModelScope.launch {
            try {
                val code = Api.RetrofitService.getValidCode(
                    GetValidCodeRequestModel(
                        email = otpVerificationUsecase.email
                    )
                )
                updateError("success")
                Log.e("", code.toString())
                otpVerificationData = otpVerificationData.copy(
                    isLoading = false,
                )
            } catch (e: Exception) {
                if (e.message != null) {
                    updateError(if (e.message!!.lowercase().contains("unable to resolve")) {"No internet"} else {e.message})
                } else {
                    updateError("Unknown error")
                }
                otpVerificationData = otpVerificationData.copy(isLoading = false)
            }
        }
    }
}

data class OtpVerificationData(
    val error: String? = null,
    val isLoading: Boolean = false,
)