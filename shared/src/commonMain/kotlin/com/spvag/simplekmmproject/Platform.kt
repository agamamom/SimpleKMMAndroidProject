package com.spvag.simplekmmproject

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform