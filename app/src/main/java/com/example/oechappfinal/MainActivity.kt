package com.example.oechappfinal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.oechappfinal.data.ApplicationContext
import com.example.oechappfinal.data.Storage
import com.example.oechappfinal.ui.navigation.NavGraph
import com.example.oechappfinal.ui.screen.onboarding.OnboardingState
import com.example.oechappfinal.ui.theme.OECHAPPFINALTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ApplicationContext.setContext(this)
        val storage: Storage = Storage(this)
//        storage.clear()
        val onboardingState = OnboardingState()
        setContent {
            OECHAPPFINALTheme {
                NavGraph(
                    if (storage.idOfOnboardingScreen <= 2) {
                        "OnboardingFirstScreen"
                    } else {
                        "HolderScreen"
                    },
                    onboardingState
                )
            }
        }
    }
}