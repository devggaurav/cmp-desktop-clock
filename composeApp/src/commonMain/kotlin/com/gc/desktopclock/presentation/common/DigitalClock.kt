package com.gc.desktopclock.presentation.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gc.desktopclock.ui.theme.GrayDark3


//
// Created by Code For Android on 13/03/25.
// Copyright (c) 2025 CFA. All rights reserved.
//

@Composable
fun DigitalClockView(hours: String, mins: String, seconds: String) {

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

}