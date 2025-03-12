package com.gc.desktopclock

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.gc.desktopclock.app.App
import com.gc.desktopclock.di.startKoin

fun main() {
    startKoin()
    application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "DesktopClock",
    ) {
        App()
    }
}
}