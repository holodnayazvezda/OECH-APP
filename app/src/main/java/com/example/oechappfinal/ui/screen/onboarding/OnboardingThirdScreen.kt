package com.example.oechappfinal.ui.screen.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.oechappfinal.R
import com.example.oechappfinal.domain.modules.Onboarding
import com.example.oechappfinal.ui.theme.AppBlue
import com.example.oechappfinal.ui.theme.OnboardingTextColor30
import com.example.oechappfinal.ui.theme.OnboardingTextColor70

@Composable
fun OnboardingThirdScreen(
    vm: OnboardingViewModel,
    navController: NavController,
    state: OnboardingState
) {

    vm.setOnboardItems(state.onboardings)
    val data: Onboarding? = vm.getOnboardItems().poll()
    if (vm.getOnboardItems().size == 0) {
        vm.setStartupTrue()
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (data != null) {
                Spacer(modifier = Modifier.padding(40.dp))
                Image(
                    painter = painterResource(id = data.imageResId),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(300.dp)

                )
                Spacer(modifier = Modifier.padding(20.dp))
                Text(
                    text = stringResource(id = data.titleTextResId),
                    textAlign = TextAlign.Center,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    color = AppBlue
                )
                Spacer(modifier = Modifier.padding(5.dp))
                Text(
                    text = stringResource(id = data.descriptionTextResId),
                    textAlign = TextAlign.Center,
                    fontSize = 15.sp,
                    color = OnboardingTextColor30,
                    modifier = Modifier.padding(start=30.dp, end = 30.dp)
                )
                Spacer(modifier = Modifier.padding(30.dp))
                Button(
                    onClick = {
                        navController.navigate("HolderScreen")
                    },
                    shape = RoundedCornerShape(5.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0560FA), contentColor = Color.White),
                    modifier = Modifier.size(width = 320.dp, height = 50.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.OnboardingButtonSignUpText),
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.padding(5.dp))
                val signInText = buildAnnotatedString {
                    append("Already have an account? ")
                    withStyle(SpanStyle(fontWeight = FontWeight.Bold, color = AppBlue)) {
                        append("Sign in")
                    }
                }
                Text(
                    text = signInText,
                    fontSize = 13.sp,
                    color = OnboardingTextColor70
                )
            }
        }
    }
}

@Preview
@Composable
private fun OnboardingSecondThirdPreview() {
    OnboardingThirdScreen(
        vm = OnboardingViewModel(),
        navController = rememberNavController(),
        state = OnboardingState()
    )
}