package com.example.oechappfinal.ui.screen.otpverification

import android.app.AlertDialog
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.oechappfinal.data.application.ApplicationContext
import com.example.oechappfinal.domain.usecase.OtpVerificationUsecase
import com.example.oechappfinal.ui.theme.AppBlue
import com.example.oechappfinal.ui.theme.GreyColor30
import com.example.oechappfinal.ui.theme.GreyColor70

@Composable
fun OtpVerificationScreen(
    vm: OtpVerificationViewModel,
    navController: NavController
) {
    val otpVerificationData = vm.otpVerificationData
    if (otpVerificationData.error == "success") {
        vm.updateError(null)
        navController.navigate("NewPasswordScreen")
    } else if (otpVerificationData.error != null) {
        vm.updateError(null)
        val builder: AlertDialog.Builder = AlertDialog.Builder(ApplicationContext.getContext())
        builder
            .setMessage(if (otpVerificationData.error == "fault") {"Wrong credentials!"} else {otpVerificationData.error})
            .setTitle((if (otpVerificationData.error == "fault") {"Credentials error"} else {"Server error"}))
            .setPositiveButton("Ok") { dialog, which ->
                dialog.cancel()
            }

        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
    if (!otpVerificationData.isLoading) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 15.dp, end = 15.dp)
            ) {
                Spacer(modifier = Modifier.padding(60.dp))
                Text(
                    text = "OTP Verification",
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
                Spacer(modifier = Modifier.padding(30.dp))
                Button(
                    onClick = {
                        vm.getValidCode()
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = AppBlue,
                        disabledContainerColor = GreyColor70
                    ),
                    shape = RoundedCornerShape(5.dp)
                ) {
                    Text(
                        text = "Set New Password",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    } else {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(color = AppBlue)
        }
    }
}

@Preview
@Composable
private fun OtpVerificationScreenPreview() {
    OtpVerificationScreen(
        OtpVerificationViewModel(OtpVerificationUsecase()),
        rememberNavController()
    )
}