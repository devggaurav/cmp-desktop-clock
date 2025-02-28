package com.gc.desktopclock

enum class Platform {
    Android,
    IOS,
    Desktop
}

expect fun getPlatform(): Platform