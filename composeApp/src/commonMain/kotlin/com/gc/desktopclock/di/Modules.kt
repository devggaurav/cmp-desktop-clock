package com.gc.desktopclock.di

import org.koin.dsl.module
import org.koin.core.module.dsl.viewModelOf
import com.gc.desktopclock.presentation.MainViewModel

//
// Created by Code For Android on 12/03/25.
// Copyright (c) 2025 CFA. All rights reserved.
//


val sharedModule = module {
    viewModelOf(::MainViewModel)
}

fun startKoin() {
    org.koin.core.context.startKoin {
        modules(sharedModule)
    }
}