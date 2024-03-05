package com.example.oechappfinal.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.oechappfinal.data.application.ApplicationContext
import com.example.oechappfinal.ui.screen.HomeScreen.HomeScreen
import com.example.oechappfinal.ui.theme.OECHAPPFINALTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ApplicationContext.setContext(this)
        setContent {
            OECHAPPFINALTheme {
                HomeScreen()
            }
        }
    }
}