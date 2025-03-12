package com.gc.desktopclock.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow


//
// Created by Code For Android on 12/03/25.
// Copyright (c) 2025 CFA. All rights reserved.
//


class MainViewModel : ViewModel() {



    private val _hours = MutableStateFlow("00")
    val hours: StateFlow<String> = _hours

    private val _mins = MutableStateFlow("00")
    val mins: StateFlow<String> = _mins

    private val _seconds = MutableStateFlow("00")
    val seconds: StateFlow<String> = _seconds

    private val _analogClock = MutableStateFlow(false)
    val analogClock: StateFlow<Boolean> = _analogClock

    init {
        viewModelScope.launch {
            while (true) {
                val now: Instant = Clock.System.now()
                val thisTime = now.toLocalDateTime(TimeZone.currentSystemDefault()).time

                _hours.value = thisTime.hour.toString().padStart(2, '0')
                _mins.value = thisTime.minute.toString().padStart(2, '0')
                _seconds.value = thisTime.second.toString().padStart(2, '0')

                delay(1000) // Update every second
            }
        }
    }

    fun toggleClockType() {
        _analogClock.value = !_analogClock.value
    }



}