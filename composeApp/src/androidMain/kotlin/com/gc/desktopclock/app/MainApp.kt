package com.gc.desktopclock.app

import android.app.Application
import com.gc.desktopclock.di.startKoin


//
// Created by Code For Android on 12/03/25.
// Copyright (c) 2025 CFA. All rights reserved.
//

class MainApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin()
    }
}