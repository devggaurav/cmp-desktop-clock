package com.gc.desktopclock.presentation.calender

import androidx.compose.runtime.Composable
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime


//
// Created by Code For Android on 14/03/25.
// Copyright (c) 2025 CFA. All rights reserved.
//

@Composable
fun CalenderView(){

    val now: Instant = Clock.System.now()
    val today: LocalDate = now.toLocalDateTime(TimeZone.currentSystemDefault()).date



}