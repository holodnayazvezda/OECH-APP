package com.example.oechappfinal.ui.screen.HomeScreen.screens.profile

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.oechappfinal.data.network.Api
import kotlinx.coroutines.launch

class ProfileViewModel : ViewModel() {
    var profileData by mutableStateOf(ProfileData())
        private set

    init {
        getBalance()
    }

    private fun getBalance() {
        profileData = profileData.copy(isLoading = true)
        viewModelScope.launch {
            try {
                val data = Api.RetrofitService.getBalance("U8Gnd4f4ibZpj2DHu7AVxC")
                profileData = profileData.copy(balance = data.balance)
                profileData = profileData.copy(isLoading = false)
            } catch (e: Exception) {
                profileData = profileData.copy(
                    isLoading = false,
                    isError = e.message
                )
            }
        }
    }
}

data class ProfileData(
    val balance: Int? = null,
    var isError: String? = null,
    val isLoading: Boolean = false
)