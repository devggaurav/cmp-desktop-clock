package com.gc.desktopclock.presentation.common


//
// Created by Code For Android on 05/03/25.
// Copyright (c) 2025 CFA. All rights reserved.
//

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gc.desktopclock.ui.theme.GrayDark2
import com.gc.desktopclock.ui.theme.GrayDark3
import desktopclock.composeapp.generated.resources.Res
import desktopclock.composeapp.generated.resources.fullscreen_24dp_e8eaed_fill0_wght400_grad0_opsz24
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.painterResource

@Composable
fun ReverseCountdownTimer(onFullScreen : () -> Unit = {}) {
    var totalSeconds by remember { mutableStateOf(0) }
    var isRunning by remember { mutableStateOf(false) }
    var inputHours by remember { mutableStateOf("0") }
    var inputMinutes by remember { mutableStateOf("0") }
    var inputSeconds by remember { mutableStateOf("0") }

    // Countdown logic
    LaunchedEffect(isRunning, totalSeconds) {
        while (isRunning && totalSeconds > 0) {
            delay(1000)
            totalSeconds--
        }
        if (totalSeconds == 0) {
            isRunning = false // Stop the timer when it reaches 0
        }
    }

    val hours = (totalSeconds / 3600).toString().padStart(2, '0')
    val minutes = ((totalSeconds % 3600) / 60).toString().padStart(2, '0')
    val seconds = (totalSeconds % 60).toString().padStart(2, '0')

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Set Countdown Timer",
            style = MaterialTheme.typography.headlineLarge,
            color = Color.White,
            fontFamily = PacificoFontFamily()

        )

        // Timer Display
        AnimatedCounter(
            "$hours:$minutes:$seconds",
            style = TextStyle(
                color = MaterialTheme.colorScheme.background,
                fontSize = 35.sp,
                fontWeight = MaterialTheme.typography.headlineLarge.fontWeight,
                fontFamily = PacificoFontFamily(),


                )
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Input Fields (only editable when not running)
        if (!isRunning) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.Bottom
            ) {
                BasicTextField(
                    value = inputHours,
                    onValueChange = { inputHours = it.filter { c -> c.isDigit() } },
                    singleLine = true,
                    modifier = Modifier.width(50.dp)
                        .border(1.dp, Color.White, shape = RoundedCornerShape(10.dp))
                        .background(GrayDark3,shape = RoundedCornerShape(10.dp))
                        .padding(10.dp),
                    textStyle = TextStyle(
                        color = Color.White,
                        fontSize = MaterialTheme.typography.headlineMedium.fontSize,
                        fontFamily = PacificoFontFamily()
                    ),
                    cursorBrush = SolidColor(Color.White)

                    )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    "h ",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontFamily = PacificoFontFamily()
                )

                BasicTextField(
                    value = inputMinutes,
                    onValueChange = { inputMinutes = it.filter { c -> c.isDigit() } },
                    singleLine = true,
                    modifier = Modifier.width(50.dp)
                        .border(1.dp, Color.White, shape = RoundedCornerShape(10.dp))
                        .background(GrayDark3,shape = RoundedCornerShape(10.dp))
                        .padding(10.dp),
                    textStyle = TextStyle(
                        color = Color.White,
                        fontSize = MaterialTheme.typography.headlineMedium.fontSize,
                        fontFamily = PacificoFontFamily()
                    ),
                    cursorBrush = SolidColor(Color.White)
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    "m ",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontFamily = PacificoFontFamily()
                )

                BasicTextField(
                    value = inputSeconds,
                    onValueChange = { inputSeconds = it.filter { c -> c.isDigit() } },
                    singleLine = true,
                    modifier = Modifier.width(50.dp)
                        .border(1.dp, Color.White, shape = RoundedCornerShape(10.dp))
                        .background(GrayDark3,shape = RoundedCornerShape(10.dp))
                        .padding(10.dp),
                    textStyle = TextStyle(
                        color = Color.White,
                        fontSize = MaterialTheme.typography.headlineMedium.fontSize,
                        fontFamily = PacificoFontFamily()
                    ),
                    cursorBrush = SolidColor(Color.White)
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    "s",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontFamily = PacificoFontFamily()
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Buttons: Start/Pause & Reset
        Row {
            Button(
                onClick = {
                    if (isRunning) {
                        isRunning = false
                    } else {
                        // Start Timer: Convert user input to total seconds
                        totalSeconds = (inputHours.toIntOrNull() ?: 0) * 3600 +
                                (inputMinutes.toIntOrNull() ?: 0) * 60 +
                                (inputSeconds.toIntOrNull() ?: 0)
                        isRunning = totalSeconds > 0
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                )
            ) {
                Text(if (isRunning) "Pause" else "Start")
            }

            Spacer(modifier = Modifier.width(8.dp))

            Button(
                onClick = {
                    isRunning = false
                    totalSeconds = 0
                    inputHours = "0"
                    inputMinutes = "0"
                    inputSeconds = "0"
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                )
            ) {
                Text("Reset")
            }

        }
        Box(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
            Icon(
                painter = painterResource(Res.drawable.fullscreen_24dp_e8eaed_fill0_wght400_grad0_opsz24),
                contentDescription = "fullscreen_icon",
                modifier = Modifier.align(Alignment.BottomEnd).clickable {
                  onFullScreen()
                },
                tint = White
            )
        }
    }
}
