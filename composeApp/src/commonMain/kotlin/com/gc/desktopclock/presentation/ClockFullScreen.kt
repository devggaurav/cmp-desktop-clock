package com.gc.desktopclock.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.gc.desktopclock.app.Route
import com.gc.desktopclock.presentation.common.AnalogClock
import com.gc.desktopclock.presentation.common.DigitalClockView
import com.gc.desktopclock.presentation.common.ItimFontFamily
import com.gc.desktopclock.ui.theme.GrayDark3
import com.gc.desktopclock.ui.theme.MatteBlack
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import org.koin.compose.viewmodel.koinViewModel


//
// Created by Code For Android on 11/03/25.
// Copyright (c) 2025 CFA. All rights reserved.
//

@Composable
fun ClockFullScreenView(viewModel: MainViewModel = koinViewModel()) {

    val seconds by viewModel.seconds.collectAsStateWithLifecycle()
    val mins by viewModel.mins.collectAsStateWithLifecycle()
    val hours by viewModel.hours.collectAsStateWithLifecycle()
    val showAnalogClock by viewModel.analogClock.collectAsStateWithLifecycle()

    val now: Instant = Clock.System.now()
    val today: LocalDate = now.toLocalDateTime(TimeZone.currentSystemDefault()).date

    Column(
        modifier = Modifier.background(MatteBlack).fillMaxSize().statusBarsPadding()
            .navigationBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Box(
            modifier = Modifier.fillMaxWidth().weight(1f),
            contentAlignment = Alignment.Center
        ) {

            if (!showAnalogClock) {
                DigitalClockView(hours, mins, seconds)
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


        }

        Box(
            modifier = Modifier.fillMaxWidth().weight(1f),
            contentAlignment = Alignment.Center
        ) {

            Text(
                text = "${today.dayOfMonth} ${today.month} ${today.year}",
                style = MaterialTheme.typography.headlineMedium,
                color = Color.White,
                fontFamily = ItimFontFamily()

            )

        }


    }

}