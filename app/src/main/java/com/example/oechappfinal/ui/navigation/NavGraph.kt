package com.example.oechappfinal.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.oechappfinal.ui.screen.holder.HolderScreen
import com.example.oechappfinal.ui.screen.onboarding.OnboardingFirstScreen
import com.example.oechappfinal.ui.screen.onboarding.OnboardingSecondScreen
import com.example.oechappfinal.ui.screen.onboarding.OnboardingState
import com.example.oechappfinal.ui.screen.onboarding.OnboardingThirdScreen
import com.example.oechappfinal.ui.screen.onboarding.OnboardingViewModel

@Composable
fun NavGraph(
    startScreen: String,
    onboardingState: OnboardingState
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startScreen) {
        composable("OnboardingFirstScreen") {
            OnboardingFirstScreen(
                vm = OnboardingViewModel(),
                navController = navController,
                state = onboardingState
            )
        }
        composable("HolderScreen") { HolderScreen() }
    }
}