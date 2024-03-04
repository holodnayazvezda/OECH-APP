package com.example.oechappfinal.ui.screen.newpassword

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.oechappfinal.R
import com.example.oechappfinal.domain.usecases.NewPasswordUseCase
import com.example.oechappfinal.ui.theme.AppBlue
import com.example.oechappfinal.ui.theme.ErrorRed
import com.example.oechappfinal.ui.theme.GreyColor30
import com.example.oechappfinal.ui.theme.GreyColor70
import com.example.oechappfinal.ui.theme.GreyColorCF

@Composable
fun NewPasswordScreen(
    vm: NewPasswordViewModel,
    navController: NavController
) {

    val newPasswordData = vm.newPasswordData

    var password by remember {
        mutableStateOf("")
    }
    var showPassword by remember {
        mutableStateOf(false)
    }
    var confirmPassword by remember {
        mutableStateOf("")
    }
    var showConfirmPassword by remember {
        mutableStateOf(false)
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
                text = "New Password",
                color = GreyColor30,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.padding(2.dp))
            Text(
                text = "Enter new password",
                color = GreyColor70,
                fontSize = 15.sp
            )
            Spacer(modifier = Modifier.padding(30.dp))
            // password
            Text(
                text = stringResource(id = R.string.PasswordText),
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = GreyColor70
            )
            Spacer(modifier = Modifier.padding(3.dp))
            OutlinedTextField(
                value = password,
                onValueChange = {
                    password = it
                    vm.updatePassword(password)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                placeholder = {
                    Text(
                        text = "**********",
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
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    IconButton(onClick = {
                        showPassword = !showPassword
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.eye_slash),
                            contentDescription = null,
                            modifier = Modifier.size(15.dp),
                            tint = Color.Unspecified
                        )
                    }
                },
                visualTransformation =
                if (showPassword) {
                    VisualTransformation.None
                } else {
                    PasswordVisualTransformation('*')
                }
            )
            // Confirm Password
            Spacer(modifier = Modifier.padding(10.dp))
            Text(
                text = stringResource(id = R.string.ConfirmPassword),
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = GreyColor70
            )
            Spacer(modifier = Modifier.padding(3.dp))
            OutlinedTextField(
                value = confirmPassword,
                onValueChange = {
                    confirmPassword = it
                    vm.updateConfirmPassword(it)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                placeholder = {
                    Text(
                        text = "**********",
                        fontSize = 15.sp,
                        color = GreyColorCF
                    )
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = if (newPasswordData.errorConfirmPassword) {ErrorRed} else {GreyColor70},
                    unfocusedBorderColor = if (newPasswordData.errorConfirmPassword) {ErrorRed} else {GreyColor70},
                    cursorColor = AppBlue,
                    focusedTextColor = if (newPasswordData.errorConfirmPassword) {ErrorRed} else {GreyColor30}
                ),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    IconButton(onClick = {
                        showConfirmPassword = !showConfirmPassword
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.eye_slash),
                            contentDescription = null,
                            modifier = Modifier.size(15.dp),
                            tint = Color.Unspecified
                        )
                    }
                },
                visualTransformation =
                if (showConfirmPassword) {
                    VisualTransformation.None
                } else {
                    PasswordVisualTransformation('*')
                }
            )
            Spacer(modifier = Modifier.padding(30.dp))
            Button(
                onClick = {
                          navController.navigate("HomeScreen")
                },
                modifier = Modifier
                    .fillMaxSize()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = AppBlue,
                    disabledContainerColor = GreyColor70
                ),
                shape = RoundedCornerShape(5.dp),
                enabled = newPasswordData.buttonEnabled
            ) {
                Text(
                    text = "Log in",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Preview
@Composable
private fun NewPasswordScreenPreview() {
    NewPasswordScreen(
        NewPasswordViewModel(NewPasswordUseCase()),
        rememberNavController()
    )
}