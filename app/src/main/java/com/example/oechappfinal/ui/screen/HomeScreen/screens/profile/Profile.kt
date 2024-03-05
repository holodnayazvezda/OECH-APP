package com.example.oechappfinal.ui.screen.HomeScreen.screens.profile

import android.app.AlertDialog
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oechappfinal.R
import com.example.oechappfinal.data.application.ApplicationContext.Companion.getContext
import com.example.oechappfinal.ui.theme.AppBlue
import com.example.oechappfinal.ui.theme.GreyColor70

@Composable
fun Profile(vm: ProfileViewModel) {
    val profileData = vm.profileData

    if (profileData.isError != null) {
        val builder = AlertDialog.Builder(getContext())
        builder
            .setTitle("Ошибка при получении данных с сервера")
            .setMessage(profileData.isError)
            .setPositiveButton("ok") { dialog, id ->
                // START THE GAME!
            }
        profileData.isError = null
        builder.create().show()

    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
    ) {
        Column {
            Column(
                Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState())
                    .shadow(elevation = 8.dp, spotColor = Color.Transparent),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.padding(20.dp))
                Text(
                    text = "Profile",
                    color = GreyColor70,
                    fontSize = 18.sp
                )
                Spacer(modifier = Modifier.padding(10.dp))
            }
            Column(
                Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState())
                    .padding(start = 20.dp, end = 20.dp),
            ) {
                Spacer(modifier = Modifier.padding(10.dp))
                Row(
                    Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.face),
                            contentDescription = null,
                            modifier = Modifier.size(60.dp)
                        )
                        Column(
                            Modifier.padding(start = 5.dp)
                        ) {
                            Text(
                                text = "Hello Ken",
                                fontSize = 18.sp,
                                color = Color.Black,
                                fontWeight = FontWeight.Bold
                            )
                            val balanceText = buildAnnotatedString {
                                withStyle(SpanStyle(color = Color.Black)) {
                                    append("Current balance: ")
                                }
                                withStyle(SpanStyle(color = AppBlue)) {
                                    if (profileData.isLoading) {
                                        append("загрузка...")
                                    } else if (profileData.balance != null) {
                                        append(profileData.balance.toString())
                                    } else {
                                        append("1")
                                    }
                                }
                            }
                            Text(
                                text = balanceText,
                                fontSize = 14.sp,
                                color = Color.Black
                            )
                        }
                    }
                }
            }
        }
    }
}