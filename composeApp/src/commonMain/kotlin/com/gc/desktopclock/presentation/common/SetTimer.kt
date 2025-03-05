package com.gc.desktopclock.presentation.common


//
// Created by Code For Android on 05/03/25.
// Copyright (c) 2025 CFA. All rights reserved.
//

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.gc.desktopclock.ui.theme.GrayDark2
import com.gc.desktopclock.ui.theme.GrayDark3
import kotlinx.coroutines.delay

@Composable
fun ReverseCountdownTimer() {
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
        // Timer Display
        Text(
            text = "$hours:$minutes:$seconds",
            style = MaterialTheme.typography.headlineLarge,
            color = Color.White
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
                        fontFamily = PacificoFontFamily()
                    ),

                    )
                Text(
                    "h ",
                    color = Color.White,
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
                        fontFamily = PacificoFontFamily()
                    ),
                )
                Text(
                    "m ",
                    color = Color.White,
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
                        fontFamily = PacificoFontFamily()
                    ),
                )
                Text(
                    "s",
                    color = Color.White,
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
                }
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
                }
            ) {
                Text("Reset")
            }
        }
    }
}
