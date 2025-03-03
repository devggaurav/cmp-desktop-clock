package com.gc.desktopclock

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.gc.desktopclock.presentation.common.AnimatedCounter
import com.gc.desktopclock.presentation.common.FontType
import com.gc.desktopclock.presentation.common.ItimFontFamily
import com.gc.desktopclock.presentation.common.OverlockFontFamily
import com.gc.desktopclock.presentation.common.PacificoFontFamily
import com.gc.desktopclock.ui.theme.MatteBlack
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import desktopclock.composeapp.generated.resources.Res
import desktopclock.composeapp.generated.resources.compose_multiplatform
import kotlinx.coroutines.delay
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

@Composable
@Preview
fun App() {
    MaterialTheme {
        var count by remember { mutableStateOf("") }

        LaunchedEffect(Unit) {
            while (true) {
                val now: Instant = Clock.System.now()
                val thisTime = now.toLocalDateTime(TimeZone.currentSystemDefault()).time
                val milliseconds = now.toEpochMilliseconds() % 1000

                count = "${thisTime.hour.toString().padStart(2, '0')}:${
                    thisTime.minute.toString().padStart(2, '0')
                }:${
                    thisTime.second.toString().padStart(2, '0')
                }"



                delay(100) // Update every 100ms for smooth updates
            }
        }

        Box(
            modifier = Modifier.fillMaxSize().background(MatteBlack),
            contentAlignment = Alignment.Center
        ) {


            AnimatedCounter(
                count,
                style = TextStyle(
                    color = MaterialTheme.colorScheme.background,
                    fontSize = 35.sp,
                    fontWeight = MaterialTheme.typography.headlineLarge.fontWeight,
                    fontFamily = PacificoFontFamily(),


                )
            )


        }


    }
}