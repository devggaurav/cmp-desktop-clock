package com.gc.desktopclock.presentation.common


//
// Created by Code For Android on 04/03/25.
// Copyright (c) 2025 CFA. All rights reserved.
//

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun AnalogClock() {
    var time by remember { mutableStateOf(Clock.System.now()) }

    // Update every second
    LaunchedEffect(Unit) {
        while (true) {
            time = Clock.System.now()
            delay(1000) // Update every second
        }
    }

    val localTime = time.toLocalDateTime(TimeZone.currentSystemDefault()).time
    val hour = localTime.hour % 12
    val minute = localTime.minute
    val second = localTime.second

    Box(modifier = Modifier.size(200.dp)) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val center = Offset(size.width / 2, size.height / 2)
            val radius = size.minDimension / 2.2f

            // Draw Clock Face
            drawCircle(color = Color.White, radius = radius, center = center, style = Stroke(width = 6.dp.toPx()))

            // Draw Hour Markers
            for (i in 0 until 12) {
                val angle = (i * 30) * (PI / 180).toFloat()
                val start = Offset(
                    center.x + (radius * 0.85f) * cos(angle),
                    center.y + (radius * 0.85f) * sin(angle)
                )
                val end = Offset(
                    center.x + radius * cos(angle),
                    center.y + radius * sin(angle)
                )
                drawLine(color = Color.Gray, start = start, end = end, strokeWidth = 4.dp.toPx())
            }

            // Draw Hour Hand
            rotate(degrees = (hour * 30 + minute * 0.5f)) {
                drawLine(color = Color.White, start = center, end = center + Offset(0f, -radius * 0.5f), strokeWidth = 8.dp.toPx())
            }

            // Draw Minute Hand
            rotate(degrees = ((minute * 6).toFloat())) {
                drawLine(color = Color.White, start = center, end = center + Offset(0f, -radius * 0.7f), strokeWidth = 6.dp.toPx())
            }

            // Draw Second Hand
            rotate(degrees = ((second * 6).toFloat())) {
                drawLine(color = Color.Red, start = center, end = center + Offset(0f, -radius * 0.85f), strokeWidth = 2.dp.toPx())
            }

            // Draw Center Dot
            drawCircle(color = Color.Red, radius = 6.dp.toPx(), center = center)
        }
    }
}
