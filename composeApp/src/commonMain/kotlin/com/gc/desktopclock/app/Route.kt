package com.gc.desktopclock.app

import kotlinx.serialization.Serializable


//
// Created by Code For Android on 11/03/25.
// Copyright (c) 2025 CFA. All rights reserved.
//

sealed interface Route {

    @Serializable
    data object ClockGraph : Route

    @Serializable
    data object MainScreen : Route

    @Serializable
    data object ClockFullScreen : Route


    @Serializable
    data object CountDownTimerFS : Route

}