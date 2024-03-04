package com.example.oechappfinal.ui.screen.login

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalMinimumInteractiveComponentEnforcement
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.oechappfinal.R
import com.example.oechappfinal.domain.usecases.LoginUseCase
import com.example.oechappfinal.ui.theme.AppBlue
import com.example.oechappfinal.ui.theme.GreyColor30
import com.example.oechappfinal.ui.theme.GreyColor70
import com.example.oechappfinal.ui.theme.GreyColorCF

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    vm: LoginViewModel,
    navController: NavController
) {

    val loginData = vm.loginData

    var emailAddress by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var showPassword by remember {
        mutableStateOf(false)
    }
    var rememberPassword by remember {
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
                text = "Welcome Back",
                color = GreyColor30,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.padding(2.dp))
            Text(
                text = "Fill in your email and password to continue",
                color = GreyColor70,
                fontSize = 15.sp
            )
            // email
            Spacer(modifier = Modifier.padding(10.dp))
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
            // password
            Spacer(modifier = Modifier.padding(10.dp))
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
                    vm.updatePassword(it)
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
            Spacer(modifier = Modifier.padding(5.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    CompositionLocalProvider(LocalMinimumInteractiveComponentEnforcement provides false) {
                        Checkbox(
                            checked = rememberPassword,
                            onCheckedChange = {
                                rememberPassword = !rememberPassword
                                vm.updateRememberPassword(rememberPassword)
                            },
                            modifier = Modifier
                                .scale(0.8f)
                                .padding(end = 1.dp),
                            colors = CheckboxDefaults.colors(checkedColor = AppBlue, uncheckedColor = GreyColor70, checkmarkColor = Color.White)
                        )
                    }
                    Text(
                        text = "Remember password",
                        fontWeight = FontWeight.Bold,
                        color = GreyColor70,
                        fontSize = 12.sp
                    )
                }
                Text(
                    text = "Forgot Password?",
                    fontWeight = FontWeight.Bold,
                    color = AppBlue,
                    fontSize = 12.sp,
                    modifier = Modifier.clickable {
                        navController.navigate("ForgotPasswordScreen")
                    }
                )
            }
            Spacer(modifier = Modifier.padding(60.dp))
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
                enabled = loginData.buttonEnabled
            ) {
                Text(
                    text = "Log in",
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
                        append("Already have an account?")
                    }
                    withStyle(SpanStyle(color = AppBlue, fontWeight = FontWeight.Bold)) {
                        append("Sign Up")
                    }
                }
                Text(
                    text = signInText,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.clickable {
                        navController.navigate("SignUpScreen")
                    }
                )
                Spacer(modifier = Modifier.padding(6.dp))
                Text(
                    text = "or log in using",
                    fontSize = 14.sp,
                    color = GreyColor70
                )
                IconButton(
                    onClick = { /*TODO*/ }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.google),
                        contentDescription = null,
                        modifier = Modifier.size(15.dp),
                        tint = Color.Unspecified,
                    )
                }
                Spacer(modifier = Modifier.size(10.dp))
            }
        }
    }
}

@Preview
@Composable
private fun LoginScreenPreview() {
    LoginScreen(
        vm = LoginViewModel(LoginUseCase()),
        navController = rememberNavController()
    )
}