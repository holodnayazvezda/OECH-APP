package com.example.oechappfinal.ui.screen.forgotpassword

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.oechappfinal.R
import com.example.oechappfinal.domain.usecase.ForgotPasswordUseCase
import com.example.oechappfinal.ui.theme.AppBlue
import com.example.oechappfinal.ui.theme.GreyColor30
import com.example.oechappfinal.ui.theme.GreyColor70
import com.example.oechappfinal.ui.theme.GreyColorCF

@Composable
fun ForgotPasswordScreen(
    vm: ForgotPasswordViewModel,
    navController: NavController
) {

    val forgotPasswordData = vm.forgotPasswordData

    var emailAddress by remember {
        mutableStateOf("")
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 15.dp, end = 15.dp)
        ) {
            Spacer(modifier = Modifier.padding(60.dp))
            Text(
                text = "Forgot Password",
                color = GreyColor30,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.padding(2.dp))
            Text(
                text = "Enter your email address",
                color = GreyColor70,
                fontSize = 15.sp
            )
            Spacer(modifier = Modifier.padding(25.dp))
            Text(
                text = stringResource(id = R.string.EmailAddressText),
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = GreyColor70
            )
            Spacer(modifier = Modifier.padding(3.dp))
            OutlinedTextField(
                value = emailAddress,
                onValueChange = {
                    emailAddress = it
                    vm.updateEmail(it)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                placeholder = {
                    Text(
                        text = "***********@mail.com",
                        fontSize = 15.sp,
                        color = GreyColorCF
                    )
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = GreyColor70,
                    unfocusedBorderColor = GreyColor70,
                    cursorColor = AppBlue,
                    focusedTextColor = GreyColor30
                ),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )
            Spacer(modifier = Modifier.padding(25.dp))
            Button(
                onClick = {
                    // todo: отправить запрос
                          navController.navigate("OtpVerificationScreen")
                },
                modifier = Modifier
                    .fillMaxSize()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = AppBlue,
                    disabledContainerColor = GreyColor70
                ),
                shape = RoundedCornerShape(5.dp),
                enabled = forgotPasswordData.isButtonEnabled
            ) {
                Text(
                    text = "Send OTP",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.padding(7.dp))
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val signInText = buildAnnotatedString {
                    withStyle(SpanStyle(color = GreyColor70)) {
                        append("Remember password? Back to")
                    }
                    withStyle(SpanStyle(color = AppBlue, fontWeight = FontWeight.Bold)) {
                        append("Sign In")
                    }
                }
                Text(
                    text = signInText,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.clickable {
                        navController.navigate("LoginScreen")
                    }
                )
            }
        }
    }
}

@Preview
@Composable
private fun ForgotPasswordScreenPreview() {
    ForgotPasswordScreen(
        ForgotPasswordViewModel(ForgotPasswordUseCase()),
        rememberNavController()
    )
}