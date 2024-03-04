package com.example.oechappfinal.ui.screen.forgotpassword

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.oechappfinal.domain.usecases.ForgotPasswordUseCase

class ForgotPasswordViewModel(private val forgotPasswordUseCase: ForgotPasswordUseCase) : ViewModel() {
    var forgotPasswordData by mutableStateOf(ForgotPasswordData())
        private set

    fun updateEmail(email: String) {
        forgotPasswordData = forgotPasswordData.copy(email = email)
        forgotPasswordData = forgotPasswordData.copy(isButtonEnabled = forgotPasswordUseCase.checkButtonEnabled(forgotPasswordData))
    }
}

data class ForgotPasswordData(
    val error: String? = null,
    val isLoading: Boolean = false,
    val email: String = "",
    val isButtonEnabled: Boolean = false
)