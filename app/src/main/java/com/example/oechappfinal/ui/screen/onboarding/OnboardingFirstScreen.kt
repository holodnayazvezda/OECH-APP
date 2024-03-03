package com.example.oechappfinal.ui.screen.onboarding

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
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
fun OnboardingFirstScreen(
    vm: OnboardingViewModel,
    navController: NavController,
    state: OnboardingState
) {

    vm.setOnboardItems(state.onboardings)
    val data: Onboarding? = vm.getOnboardItems().peek()
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
                    modifier = if (vm.getOnboardItems().size != 1) {Modifier.padding(start=40.dp, end = 40.dp)} else {Modifier.padding(start=20.dp, end = 20.dp)}
                )
                Spacer(modifier = Modifier.padding(30.dp))
                if (vm.getOnboardItems().size > 1) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 25.dp, end = 25.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        OutlinedButton(
                            onClick = {
                                vm.setIdOfOnboardingScreen(3)
                                vm.getOnboardItems().clear()
                                navController.navigate("HolderScreen")
                            },
                            shape = RoundedCornerShape(5.dp),
                            border = BorderStroke(width = 2.dp, color = Color(0xFF0560FA)),
                            modifier = Modifier.size(width = 85.dp, height = 50.dp)
                        ) {
                            Text(
                                text = stringResource(id = R.string.OnboardingButtonSkipText),
                                color = AppBlue,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Button(
                            onClick = {
                                vm.getOnboardItems().poll()
                                vm.setIdOfOnboardingScreen(3 - vm.getOnboardItems().size)
                                navController.navigate("OnboardingFirstScreen")
                            },
                            shape = RoundedCornerShape(5.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0560FA), contentColor = Color.White),
                            modifier = Modifier.size(width = 85.dp, height = 50.dp)
                        ) {
                            Text(
                                text = stringResource(id = R.string.OnboardingButtonNextText),
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                } else {
                    Button(
                        onClick = {
                            vm.setIdOfOnboardingScreen(3)
                            vm.getOnboardItems().clear()
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
                        color = OnboardingTextColor70,
                        modifier = Modifier.clickable {
                            navController.navigate("HolderScreen")
                        }
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun OnboardingFirstScreenPreview() {
    OnboardingFirstScreen(
        vm = OnboardingViewModel(),
        navController = rememberNavController(),
        state = OnboardingState()
    )
}