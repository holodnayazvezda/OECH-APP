package com.example.oechappfinal.data


import android.content.Context
import android.util.Log


private const val SharedPreferenceName = "app_preferences"
private const val Password = "password"
private const val IdOfOnboardingScreen = "id_of_onboarding_screen"

class Storage(context: Context) {
    private val prefs = context.getSharedPreferences(
        SharedPreferenceName,
        Context.MODE_PRIVATE
    )

    private fun getString(key: String): String? {
        return prefs.getString(key, null)
    }

    private fun putString(key: String, value: String?) {
        prefs.edit()
            .putString(key, value)
            .apply()
    }

    fun clear() {
        prefs.edit().clear().apply()
    }

    var password: String?
        get() {
            val storedPassword = getString(Password)
            Log.d("Storage", "Getting password: $storedPassword")
            return storedPassword
        }
        set(value) {
            Log.d("Storage", "Setting password: $value")
            putString(Password, value)
        }

    var idOfOnboardingScreen: Int
        get() {
            val screenId = getString(IdOfOnboardingScreen)
            return screenId?.toInt() ?: 0
        }

        set(value) {
            putString(IdOfOnboardingScreen, value.toString())
        }
}