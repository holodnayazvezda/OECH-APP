package com.example.oechappfinal.domain.usecase

import com.example.oechappfinal.ui.screen.forgotpassword.ForgotPasswordData

class ForgotPasswordUseCase {
    fun checkButtonEnabled(forgotPasswordData: ForgotPasswordData): Boolean {
        return forgotPasswordData.email.isNotEmpty()
    }
}