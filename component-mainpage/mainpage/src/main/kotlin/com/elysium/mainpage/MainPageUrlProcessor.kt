package com.elysium.mainpage

import com.elysium.basic.url.ElysiumUrlProcessor
import zhupf.gadget.spi.SpiAnnotation

@SpiAnnotation(ElysiumUrlProcessor::class)
class MainPageUrlProcessor : ElysiumUrlProcessor() {

    override val path: String = "mainpage"
}