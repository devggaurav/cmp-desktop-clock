package com.gc.desktopclock.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.russhwolf.settings.ObservableSettings
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
const val ANALOG_CLOCK = "analogClock"

class MainViewModel(private val settings: ObservableSettings) : ViewModel() {



    private val _hours = MutableStateFlow("00")
    val hours: StateFlow<String> = _hours

    private val _mins = MutableStateFlow("00")
    val mins: StateFlow<String> = _mins

    private val _seconds = MutableStateFlow("00")
    val seconds: StateFlow<String> = _seconds

    private var _analogClock = MutableStateFlow(settings.getBoolean(ANALOG_CLOCK, false))
    val analogClock: StateFlow<Boolean> = _analogClock

    init {
        viewModelScope.launch {
            launch { observeTime() }
            launch { observeSettings() }
        }
    }

    private suspend fun observeTime() {
        while (true) {
            val now: Instant = Clock.System.now()
            val thisTime = now.toLocalDateTime(TimeZone.currentSystemDefault()).time

            _hours.value = thisTime.hour.toString().padStart(2, '0')
            _mins.value = thisTime.minute.toString().padStart(2, '0')
            _seconds.value = thisTime.second.toString().padStart(2, '0')

            delay(1000) // Update every second
        }
    }

    private fun observeSettings() {
       _analogClock.value = settings.getBoolean(ANALOG_CLOCK,false)
    }

    fun toggleClockType() {
        val newValue = !_analogClock.value
        _analogClock.value = newValue
        settings.putBoolean(ANALOG_CLOCK, newValue)
    }



}