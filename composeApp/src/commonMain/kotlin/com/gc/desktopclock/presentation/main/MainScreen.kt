package com.gc.desktopclock.presentation.main

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gc.desktopclock.presentation.common.AnalogClock
import com.gc.desktopclock.presentation.common.AnimatedCounter
import com.gc.desktopclock.presentation.common.ItimFontFamily
import com.gc.desktopclock.presentation.common.PacificoFontFamily
import com.gc.desktopclock.presentation.common.ReverseCountdownTimer
import com.gc.desktopclock.ui.theme.GrayDark3
import com.gc.desktopclock.ui.theme.MatteBlack
import desktopclock.composeapp.generated.resources.Res
import desktopclock.composeapp.generated.resources.fullscreen_24dp_e8eaed_fill0_wght400_grad0_opsz24
import kotlinx.coroutines.delay
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import org.jetbrains.compose.resources.painterResource


//
// Created by Code For Android on 11/03/25.
// Copyright (c) 2025 CFA. All rights reserved.
//

@Composable
fun MainScreenView(){

    var seconds by remember { mutableStateOf("") }
    var mins by remember { mutableStateOf("") }
    var hours by remember { mutableStateOf("") }
    var analogClock by remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()

    val now: Instant = Clock.System.now()
    val today: LocalDate = now.toLocalDateTime(TimeZone.currentSystemDefault()).date

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

    Column(
        modifier = Modifier.fillMaxSize().heightIn(min = 400.dp).widthIn(min = 300.dp)
            .background(MatteBlack).statusBarsPadding().navigationBarsPadding()
            .verticalScroll(scrollState).imePadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top

    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Desktop Clock",
                color = White,
                modifier = Modifier,
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = MaterialTheme.typography.headlineLarge.fontWeight
                ),
                fontFamily = PacificoFontFamily()
            )
        }
        Spacer(Modifier.padding(8.dp))
        HorizontalDivider(color = White)
        Spacer(Modifier.padding(8.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth().padding(start = 10.dp, end = 10.dp)
        ) {
            Text(
                text = if (analogClock) "Analog Clock" else "Digital Clock",
                color = White,
                modifier = Modifier,
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = MaterialTheme.typography.headlineLarge.fontWeight
                ),
                fontFamily = PacificoFontFamily()
            )
            Switch(
                checked = analogClock,
                onCheckedChange = { analogClock = !analogClock },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = MaterialTheme.colorScheme.primary,
                    checkedTrackColor = MaterialTheme.colorScheme.primaryContainer,
                    uncheckedThumbColor = White,
                    uncheckedTrackColor = GrayDark3
                ),
                modifier = Modifier
            )
        }

        if (!analogClock) {

            Row(
                horizontalArrangement = Arrangement.spacedBy(5.dp),
                verticalAlignment = Alignment.CenterVertically,

                ) {

                Box(
                    modifier = Modifier.wrapContentSize()
                        .background(GrayDark3, shape = RoundedCornerShape(20.dp))
                        .padding(16.dp),
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
                        .background(GrayDark3, shape = RoundedCornerShape(20.dp))
                        .padding(16.dp),
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
                        .background(GrayDark3, shape = RoundedCornerShape(20.dp))
                        .padding(16.dp),
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
        } else {
            Spacer(Modifier.padding(10.dp))

            Box(
                modifier = Modifier.wrapContentSize()
                    .background(GrayDark3, shape = RoundedCornerShape(20.dp)).padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                AnalogClock()
            }


        }

        Spacer(Modifier.padding(8.dp))
        Text(
            text = "${today.dayOfMonth} ${today.month} ${today.year}",
            style = MaterialTheme.typography.headlineMedium,
            color = Color.White,
            fontFamily = ItimFontFamily()

        )
        Box(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
            Icon(
                painter = painterResource(Res.drawable.fullscreen_24dp_e8eaed_fill0_wght400_grad0_opsz24),
                contentDescription = "fullscreen_icon",
                modifier = Modifier.align(Alignment.BottomEnd).clickable {

                },
                tint = White
            )
        }

        Spacer(Modifier.padding(8.dp))
        HorizontalDivider(color = White)
        Spacer(Modifier.padding(8.dp))
        ReverseCountdownTimer()
    }

}