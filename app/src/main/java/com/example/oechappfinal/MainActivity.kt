package com.example.oechappfinal

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
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
                    if (storage.isStartup == null) {
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