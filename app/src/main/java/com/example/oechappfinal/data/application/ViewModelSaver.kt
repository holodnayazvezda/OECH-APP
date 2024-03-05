package com.example.oechappfinal.data.application

import com.example.oechappfinal.ui.screen.HomeScreen.screens.profile.ProfileViewModel

abstract class ViewModelSaver {
    companion object {
        var profileViewModel: ProfileViewModel = ProfileViewModel()
    }
}