package com.gc.desktopclock.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.gc.desktopclock.app.Route
import com.gc.desktopclock.ui.theme.MatteBlack
import org.koin.compose.viewmodel.koinViewModel


//
// Created by Code For Android on 11/03/25.
// Copyright (c) 2025 CFA. All rights reserved.
//

@Composable
fun ClockFullScreenView(viewModel: MainViewModel = koinViewModel()) {

     val showAnalogClock by viewModel.analogClock.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier.background(MatteBlack).fillMaxSize().statusBarsPadding()
            .navigationBarsPadding()
    ) {

        Box(modifier = Modifier.fillMaxWidth().weight(1f)) {

            if (showAnalogClock){


            }else {

            }



        }


    }

}