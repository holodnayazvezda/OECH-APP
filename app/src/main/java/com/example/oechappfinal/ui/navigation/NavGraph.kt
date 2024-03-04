package com.example.oechappfinal.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.oechappfinal.domain.usecase.ForgotPasswordUseCase
import com.example.oechappfinal.domain.usecase.LoginUseCase
import com.example.oechappfinal.domain.usecase.NewPasswordUseCase
import com.example.oechappfinal.domain.usecase.OtpVerificationUsecase
import com.example.oechappfinal.domain.usecase.SignUpUseCase
import com.example.oechappfinal.ui.screen.forgotpassword.ForgotPasswordScreen
import com.example.oechappfinal.ui.screen.forgotpassword.ForgotPasswordViewModel
import com.example.oechappfinal.ui.screen.holder.HolderScreen
import com.example.oechappfinal.ui.screen.home.HomeScreen
import com.example.oechappfinal.ui.screen.login.LoginScreen
import com.example.oechappfinal.ui.screen.login.LoginViewModel
import com.example.oechappfinal.ui.screen.newpassword.NewPasswordScreen
import com.example.oechappfinal.ui.screen.newpassword.NewPasswordViewModel
import com.example.oechappfinal.ui.screen.onboarding.OnboardingData
import com.example.oechappfinal.ui.screen.onboarding.OnboardingFirstScreen
import com.example.oechappfinal.ui.screen.onboarding.OnboardingViewModel
import com.example.oechappfinal.ui.screen.otpverification.OtpVerificationScreen
import com.example.oechappfinal.ui.screen.otpverification.OtpVerificationViewModel
import com.example.oechappfinal.ui.screen.signup.SignUpScreen
import com.example.oechappfinal.ui.screen.signup.SignUpViewModel

@Composable
fun NavGraph(
    startScreen: String,
    onboardingData: OnboardingData
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startScreen) {
        composable("OnboardingFirstScreen") {
            OnboardingFirstScreen(
                vm = OnboardingViewModel(),
                navController = navController,
                state = onboardingData
            )
        }
        composable("HolderScreen") { HolderScreen() }
        composable("SignUpScreen") {
            SignUpScreen(
                vm = SignUpViewModel(SignUpUseCase()),
                navController = navController
            )
        }
        composable("LoginScreen") {
            LoginScreen(
                vm = LoginViewModel(LoginUseCase()),
                navController = navController,
                loginUseCase = LoginUseCase()
            )
        }
        composable("ForgotPasswordScreen") {
            ForgotPasswordScreen(
                vm = ForgotPasswordViewModel(ForgotPasswordUseCase()),
                navController = navController
            )
        }
        composable("OtpVerificationScreen") {
            OtpVerificationScreen(
                OtpVerificationViewModel(OtpVerificationUsecase()),
                navController
            )
        }
        composable("NewPasswordScreen") {
            NewPasswordScreen(
                vm = NewPasswordViewModel(NewPasswordUseCase()),
                navController = navController
            )
        }
        composable("HomeScreen") { HomeScreen()}
    }
}