package com.example.oechappfinal.ui.screen.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.oechappfinal.domain.usecases.LoginUseCase

class LoginViewModel(private val loginUseCase: LoginUseCase) : ViewModel() {
    var loginData by mutableStateOf(LoginData())
        private set

    fun updateEmail(email: String) {
        loginData = loginData.copy(email = email)
        loginData = loginData.copy(buttonEnabled = loginUseCase.checkButtonEnabled(loginData))
    }

    fun updatePassword(password: String) {
        loginData = loginData.copy(password = password)
        loginData = loginData.copy(buttonEnabled = loginUseCase.checkButtonEnabled(loginData))
    }

    fun updateRememberPassword(rememberPassword: Boolean) {
        loginData = loginData.copy(rememberPassword = rememberPassword)
    }
}

data class LoginData(
    val error: String? = null,
    val isLoading: Boolean = false,
    val email: String = "",
    val password: String = "",
    val rememberPassword: Boolean = false,
    val buttonEnabled: Boolean = false
)