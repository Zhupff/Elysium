package com.elysium.basic.url

import android.content.Context
import androidx.startup.Initializer
import zhupf.gadget.spi.SPI

class BasicUrlInitializer : Initializer<Unit> {

    override fun create(context: Context) {
        SPI(context.classLoader).create(ElysiumUrlProcessor::class.java).forEach { processor ->
            ElysiumUrlProcessor.PROCESSORS[processor.path] = processor
        }
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}