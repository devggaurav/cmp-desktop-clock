package com.gc.desktopclock

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform