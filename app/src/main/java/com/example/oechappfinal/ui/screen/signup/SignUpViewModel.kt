package com.example.oechappfinal.ui.screen.signup

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.oechappfinal.domain.usecases.SignUpUseCase

class SignUpViewModel(private val signUpUseCase: SignUpUseCase) : ViewModel() {
    var signUpData by mutableStateOf(SignUpData())
        private set

    fun updateName(name: String) {
        signUpData = signUpData.copy(fullName = name)
        signUpData = signUpData.copy(buttonEnabled = signUpUseCase.checkButtonEnabled(signUpData))
    }

    fun updatePhoneNumber(phoneNumber: String) {
        signUpData = signUpData.copy(phoneNumber = phoneNumber)
        signUpData = signUpData.copy(buttonEnabled = signUpUseCase.checkButtonEnabled(signUpData))
    }

    fun updateEmailAddress(emailAddress: String) {
        signUpData = signUpData.copy(
            emailAddress = emailAddress,
            errorEmailAddress = signUpUseCase.checkEmailAddress(emailAddress)
        )
        signUpData = signUpData.copy(buttonEnabled = signUpUseCase.checkButtonEnabled(signUpData))
    }

    fun updatePassword(password: String) {
        signUpData = signUpData.copy(
            password = password,
            errorConfirmPassword = signUpUseCase.checkConfirmPassword(password, signUpData.confirmPassword)
        )
        signUpData = signUpData.copy(buttonEnabled = signUpUseCase.checkButtonEnabled(signUpData))
    }

    fun updateConfirmPassword(confirmPassword: String) {
        signUpData = signUpData.copy(
            confirmPassword = confirmPassword,
            errorConfirmPassword = signUpUseCase.checkConfirmPassword(signUpData.password, confirmPassword)
        )
        signUpData = signUpData.copy(buttonEnabled = signUpUseCase.checkButtonEnabled(signUpData))
    }

    fun setAgreeWithTerms(agreeWithTerms: Boolean) {
        signUpData = signUpData.copy(agreeWithTerms = agreeWithTerms)
        signUpData = signUpData.copy(buttonEnabled = signUpUseCase.checkButtonEnabled(signUpData))
    }

    private fun checkButtonEnabled() {
        val checkResult =
            signUpData.fullName.isNotEmpty() &&
            signUpData.phoneNumber.isNotEmpty() &&
            signUpData.emailAddress.isNotEmpty() &&
            !signUpData.errorEmailAddress &&
            signUpData.password.isNotEmpty() &&
            signUpData.confirmPassword.isNotEmpty() &&
            !signUpData.errorConfirmPassword &&
            signUpData.agreeWithTerms
        signUpData = signUpData.copy(buttonEnabled = checkResult)
    }
}

data class SignUpData (
    val error: String? = null,
    val isLoading: Boolean = false,
    val fullName: String = "",
    val phoneNumber: String = "",
    val emailAddress: String = "",
    val errorEmailAddress: Boolean = false,
    val password: String = "",
    val confirmPassword: String = "",
    val errorConfirmPassword: Boolean = false,
    val agreeWithTerms: Boolean = false,
    val buttonEnabled: Boolean = false
)