package com.example.oechappfinal.domain.usecase

import com.example.oechappfinal.ui.screen.newpassword.NewPasswordData

class NewPasswordUseCase {
    fun checkConfirmPassword(password: String, confirmPassword: String): Boolean {
        return password != confirmPassword
    }

    fun checkButtonEnabled(newPasswordData: NewPasswordData): Boolean {
        return newPasswordData.password.isNotEmpty() &&
                newPasswordData.confirmPassword.isNotEmpty() &&
                !newPasswordData.errorConfirmPassword
    }
}