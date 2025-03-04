package com.gc.desktopclock

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gc.desktopclock.presentation.common.AnalogClock
import com.gc.desktopclock.presentation.common.AnimatedCounter
import com.gc.desktopclock.presentation.common.FontType
import com.gc.desktopclock.presentation.common.ItimFontFamily
import com.gc.desktopclock.presentation.common.OverlockFontFamily
import com.gc.desktopclock.presentation.common.PacificoFontFamily
import com.gc.desktopclock.ui.theme.GRAY
import com.gc.desktopclock.ui.theme.GrayDark1
import com.gc.desktopclock.ui.theme.GrayDark2
import com.gc.desktopclock.ui.theme.GrayDark3
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
        var seconds by remember { mutableStateOf("") }
        var mins by remember { mutableStateOf("") }
        var hours by remember { mutableStateOf("") }

        LaunchedEffect(Unit) {
            while (true) {
                val now: Instant = Clock.System.now()
                val thisTime = now.toLocalDateTime(TimeZone.currentSystemDefault()).time
                val milliseconds = now.toEpochMilliseconds() % 1000

                hours = thisTime.hour.toString().padStart(2, '0')
                mins = thisTime.minute.toString().padStart(2, '0')
                seconds = thisTime.second.toString().padStart(2, '0')



                delay(1000) // Update every 100ms for smooth updates
            }
        }

        Box(
            modifier = Modifier.fillMaxSize().background(MatteBlack),

            ) {

            Row(
                horizontalArrangement = Arrangement.spacedBy(5.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.align(Alignment.TopCenter)
            ) {

                Box(
                    modifier = Modifier.wrapContentSize()
                        .background(GrayDark3, shape = RoundedCornerShape(20.dp)).padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    AnimatedCounter(
                        hours,
                        style = TextStyle(
                            color = MaterialTheme.colorScheme.background,
                            fontSize = 35.sp,
                            fontWeight = MaterialTheme.typography.headlineLarge.fontWeight,
                            fontFamily = PacificoFontFamily(),


                            )
                    )
                }
                Box(
                    modifier = Modifier.wrapContentSize()
                        .background(GrayDark3, shape = RoundedCornerShape(20.dp)).padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    AnimatedCounter(
                        mins,
                        style = TextStyle(
                            color = MaterialTheme.colorScheme.background,
                            fontSize = 35.sp,
                            fontWeight = MaterialTheme.typography.headlineLarge.fontWeight,
                            fontFamily = PacificoFontFamily(),


                            )
                    )
                }
                Box(
                    modifier = Modifier.wrapContentSize()
                        .background(GrayDark3, shape = RoundedCornerShape(20.dp)).padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    AnimatedCounter(
                        seconds,
                        style = TextStyle(
                            color = MaterialTheme.colorScheme.background,
                            fontSize = 35.sp,
                            fontWeight = MaterialTheme.typography.headlineLarge.fontWeight,
                            fontFamily = PacificoFontFamily(),


                            )
                    )
                }
            }


            AnalogClock()


        }


    }
}