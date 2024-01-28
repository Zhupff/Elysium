package com.elysium

import android.app.Application
import android.content.res.Resources
import java.io.File

class Elysium : Application() {
    companion object {

        lateinit var APPLICATION: Application
            private set

        val RESOURCES: Resources
            get() = APPLICATION.resources

        val CACHE_DIR: File
            get() = APPLICATION.cacheDir
    }

    init {
        APPLICATION = this
    }
}