package com.example.oechappfinal.domain.usecases

import com.example.oechappfinal.ui.screen.login.LoginData

class LoginUseCase {
    fun checkButtonEnabled(loginData: LoginData): Boolean {
        return loginData.email.isNotEmpty() && loginData.password.isNotEmpty()
    }
}