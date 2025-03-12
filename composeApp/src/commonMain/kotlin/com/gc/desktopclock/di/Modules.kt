package com.gc.desktopclock.di

import org.koin.dsl.module
import org.koin.core.module.dsl.viewModelOf
import com.gc.desktopclock.presentation.MainViewModel
import com.russhwolf.settings.ExperimentalSettingsApi
import com.russhwolf.settings.ObservableSettings
import com.russhwolf.settings.Settings
import com.russhwolf.settings.observable.makeObservable

//
// Created by Code For Android on 12/03/25.
// Copyright (c) 2025 CFA. All rights reserved.
//


@OptIn(ExperimentalSettingsApi::class)
val sharedModule = module {
    single<ObservableSettings> { Settings().makeObservable() }
    viewModelOf(::MainViewModel)
}

fun startKoin() {
    org.koin.core.context.startKoin {
        modules(sharedModule)
    }
}