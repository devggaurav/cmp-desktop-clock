package com.gc.desktopclock

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.gc.desktopclock.app.App

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "DesktopClock",
    ) {
        App()
    }
}