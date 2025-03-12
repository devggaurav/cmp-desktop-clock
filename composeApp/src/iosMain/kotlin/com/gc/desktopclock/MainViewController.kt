package com.gc.desktopclock

import androidx.compose.ui.window.ComposeUIViewController
import com.gc.desktopclock.app.App
import com.gc.desktopclock.di.startKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        startKoin()
    }
) { App() }