package com.example.oechappfinal.domain.usecases

import com.example.oechappfinal.ui.screen.signup.SignUpData

class SignUpUseCase {
    fun checkEmailAddress(emailAddress: String): Boolean {
        val regex = Regex("""([a-z0-9]+)@([a-z0-9]{3,})\.([a-z]{2,3})""")
        return !regex.matches(emailAddress)
    }

    fun checkConfirmPassword(password: String, confirmPassword: String): Boolean {
        return password != confirmPassword
    }

    fun checkButtonEnabled(signUpData: SignUpData): Boolean {
        return signUpData.fullName.isNotEmpty() &&
                signUpData.phoneNumber.isNotEmpty() &&
                signUpData.emailAddress.isNotEmpty() &&
                !signUpData.errorEmailAddress &&
                signUpData.password.isNotEmpty() &&
                signUpData.confirmPassword.isNotEmpty() &&
                !signUpData.errorConfirmPassword &&
                signUpData.agreeWithTerms
    }
}