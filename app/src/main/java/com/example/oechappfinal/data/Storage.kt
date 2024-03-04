package com.example.oechappfinal.data


import android.content.Context


private const val SharedPreferenceName = "app_preferences"
private const val IdOfOnboardingScreen = "id_of_onboarding_screen"
private const val ValidCode = "valid_code"

class Storage(context: Context) {
    private val prefs = context.getSharedPreferences(
        SharedPreferenceName,
        Context.MODE_PRIVATE
    )

    fun getString(key: String): String? {
        return prefs.getString(key, null)
    }

    fun putString(key: String, value: String?) {
        prefs.edit()
            .putString(key, value)
            .apply()
    }

    fun clear() {
        prefs.edit().clear().apply()
    }



    var idOfOnboardingScreen: Int
        get() {
            val screenId = getString(IdOfOnboardingScreen)
            return screenId?.toInt() ?: 0
        }

        set(value) {
            putString(IdOfOnboardingScreen, value.toString())
        }
    // перенести в useCases
    var validCode: Int
        get() {
            val validCode = getString(ValidCode)
            return validCode?.toInt() ?: 0
        }

        set(value) {
            putString(ValidCode, value.toString())
        }
}