package com.gc.desktopclock.presentation.calender

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.gc.desktopclock.presentation.calender.Days.daysList
import com.gc.desktopclock.presentation.calender.Days.getDaysInMonth
import com.gc.desktopclock.presentation.calender.Days.getFirstDayOfWeek
import com.gc.desktopclock.presentation.common.ItimFontFamily
import com.gc.desktopclock.ui.theme.MatteBlack
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
fun CalenderView() {

    val now: Instant = Clock.System.now()
    val today: LocalDate = now.toLocalDateTime(TimeZone.currentSystemDefault()).date

    val daysInMonth = getDaysInMonth(today.year, today.monthNumber)
    val firstDayOfWeek = getFirstDayOfWeek(today.year, today.monthNumber)

    val days = List(firstDayOfWeek) { "" } + (1..daysInMonth).map { it.toString() }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.background(MatteBlack).fillMaxSize()
    ) {

        Spacer(Modifier.padding(8.dp))
        Text(
            text = "${today.month} ${today.year}",
            style = MaterialTheme.typography.headlineMedium,
            color = Color.White,
            fontFamily = ItimFontFamily()

        )
        Spacer(Modifier.padding(8.dp))
        LazyVerticalGrid(columns = GridCells.Fixed(7), modifier = Modifier.fillMaxWidth().padding(5.dp)) {
            items(daysList){
                Text(text = it, color = Color.White, fontFamily = ItimFontFamily(), textAlign = TextAlign.Center)
            }

            items(days) { day ->
                Text(
                    text = day,
                    modifier = Modifier
                        .padding(8.dp)
                        .size(30.dp)
                        .background(if (day.isNotEmpty()) Color.LightGray else if (day == today.dayOfMonth.toString()) Color.White else Color.Transparent, shape = CircleShape)
                        .wrapContentHeight(Alignment.CenterVertically)
                        .wrapContentWidth(Alignment.CenterHorizontally),
                    textAlign = TextAlign.Center,
                    fontFamily = ItimFontFamily()
                )
            }


        }


    }

}