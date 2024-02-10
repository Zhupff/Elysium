package com.elysium.basic.url

abstract class ElysiumUrlProcessor {
    companion object {
        const val PROTOCOL: String = "elysium://"

        internal val PROCESSORS = HashMap<String, ElysiumUrlProcessor>()

        fun isElysiumUrl(url: String): Boolean = url.startsWith(PROTOCOL)

        fun parse(url: String) {}
    }

    abstract val path: String
}