package com.example.oechappfinal.ui.screen.HomeScreen

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.oechappfinal.data.application.ViewModelSaver
import com.example.oechappfinal.ui.BottomScreen
import com.example.oechappfinal.ui.screen.HomeScreen.screens.Home
import com.example.oechappfinal.ui.screen.HomeScreen.screens.Track
import com.example.oechappfinal.ui.screen.HomeScreen.screens.Wallet
import com.example.oechappfinal.ui.screen.HomeScreen.screens.profile.Profile

@Composable
fun BottomNavGraph(
    navController: NavHostController,
) {
    NavHost(navController = navController, startDestination = BottomScreen.Home.route) {
        composable(BottomScreen.Home.route) { Home() }
        composable(BottomScreen.Wallet.route) {Wallet()}
        composable(BottomScreen.Track.route) { Track()}
        composable(BottomScreen.Profile.route) { Profile(ViewModelSaver.profileViewModel) }
    }
}