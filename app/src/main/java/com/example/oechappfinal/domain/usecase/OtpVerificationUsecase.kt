package com.example.oechappfinal.domain.usecase

import com.example.oechappfinal.data.Storage
import com.example.oechappfinal.data.application.ApplicationContext

private const val Email = "email"

class OtpVerificationUsecase {
    var email: String?
        get() {
            return Storage(ApplicationContext.getContext()).getString(Email)
        }

        set(value) {
            Storage(ApplicationContext.getContext()).putString(Email, value)
        }
}