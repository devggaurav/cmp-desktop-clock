package com.gc.desktopclock.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.gc.desktopclock.app.Route
import com.gc.desktopclock.ui.theme.MatteBlack


//
// Created by Code For Android on 11/03/25.
// Copyright (c) 2025 CFA. All rights reserved.
//

@Composable
fun ClockFullScreenView() {

    Column(
        modifier = Modifier.background(MatteBlack).fillMaxSize().statusBarsPadding()
            .navigationBarsPadding()
    ) {

    }

}