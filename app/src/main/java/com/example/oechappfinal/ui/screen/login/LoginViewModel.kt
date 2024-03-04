package com.example.oechappfinal.ui.screen.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.oechappfinal.data.model.SignIn.SignInRequestModel
import com.example.oechappfinal.data.network.Api
import com.example.oechappfinal.domain.usecase.LoginUseCase
import kotlinx.coroutines.launch

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

    fun updateError(error: String?) {
        loginData = loginData.copy(error = error)
    }

    fun signIn() {
        loginData = loginData.copy(isLoading = true)
        viewModelScope.launch {
            try {
                val res = Api.RetrofitService.SignIn(
                    SignInRequestModel(
                        email = loginData.email,
                        password = loginData.password
                    )
                )
                updateError(res.message)
                loginData = loginData.copy(isLoading = false)
            } catch (e: Exception) {
                if (e.message != null) {
                    updateError(if (e.message!!.lowercase().contains("unable to resolve")) {"No internet"} else {e.message})
                } else {
                    updateError("Unknown error")
                }
                loginData = loginData.copy(isLoading = false)
            }
        }
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