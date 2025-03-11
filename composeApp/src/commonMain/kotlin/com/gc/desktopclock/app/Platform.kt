package com.gc.desktopclock.app

enum class Platform {
    Android,
    IOS,
    Desktop
}

expect fun getPlatform(): Platform