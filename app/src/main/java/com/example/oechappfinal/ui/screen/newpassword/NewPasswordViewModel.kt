package com.example.oechappfinal.ui.screen.newpassword

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.oechappfinal.domain.usecase.NewPasswordUseCase

class NewPasswordViewModel(private val newPasswordUseCase: NewPasswordUseCase) : ViewModel() {
    var newPasswordData by mutableStateOf(NewPasswordData())
        private set

    fun updatePassword(password: String) {
        newPasswordData = newPasswordData.copy(
            password = password,
            errorConfirmPassword = newPasswordUseCase.checkConfirmPassword(password, newPasswordData.confirmPassword)
        )
        newPasswordData = newPasswordData.copy(buttonEnabled = newPasswordUseCase.checkButtonEnabled(newPasswordData))
    }

    fun updateConfirmPassword(confirmPassword: String) {
        newPasswordData = newPasswordData.copy(
            confirmPassword = confirmPassword,
            errorConfirmPassword = newPasswordUseCase.checkConfirmPassword(newPasswordData.password, confirmPassword)
        )
        newPasswordData = newPasswordData.copy(buttonEnabled = newPasswordUseCase.checkButtonEnabled(newPasswordData))
    }

    private fun checkButtonEnabled() {
        val checkResult =
            newPasswordData.password.isNotEmpty() &&
            newPasswordData.confirmPassword.isNotEmpty() &&
            !newPasswordData.errorConfirmPassword
        newPasswordData = newPasswordData.copy(buttonEnabled = checkResult)
    }
}

data class NewPasswordData(
    val error: String? = null,
    val isLoading: Boolean = false,
    val password: String = "",
    val confirmPassword: String = "",
    val errorConfirmPassword: Boolean = false,
    val buttonEnabled: Boolean = false
)