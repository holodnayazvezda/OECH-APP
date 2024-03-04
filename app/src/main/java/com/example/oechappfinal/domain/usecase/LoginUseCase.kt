package com.example.oechappfinal.domain.usecase

import android.util.Log
import com.example.oechappfinal.data.Storage
import com.example.oechappfinal.data.application.ApplicationContext.Companion.getContext
import com.example.oechappfinal.ui.screen.login.LoginData

private const val Password = "password"
private const val Email = "email"

class LoginUseCase {
    fun checkButtonEnabled(loginData: LoginData): Boolean {
        return loginData.email.isNotEmpty() && loginData.password.isNotEmpty()
    }

    var password: String?
        get() {
            val storedPassword = Storage(getContext()).getString(Password)
            Log.d("Storage", "Getting password: $storedPassword")
            return storedPassword
        }
        set(value) {
            Log.d("Storage", "Setting password: $value")
            Storage(getContext()).putString(Password, value)
        }

    var email: String?
        get() {
            return Storage(getContext()).getString(Email)
        }

        set(value) {
            Storage(getContext()).putString(Email, value)
        }
}