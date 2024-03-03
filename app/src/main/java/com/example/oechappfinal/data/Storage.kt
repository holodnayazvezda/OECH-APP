package com.example.oechappfinal.data


import android.content.Context
import android.util.Log

private const val SharedPreferenceName = "app_preferences"
private const val IsStartup = "is_startup"
private const val Password = "password"

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
        prefs.edit().remove(IsStartup).apply()
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


    var isStartup: String?
        get() {
            return getString(IsStartup)
        }
        set(value) {
            putString(IsStartup, value)
        }
}