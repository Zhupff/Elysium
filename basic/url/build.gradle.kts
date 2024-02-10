import zhupf.gadget.spi.Spi

plugins {
    id("com.elysium.library")
}

script {
    configuration("com.elysium.basic.scheme") {
        configure()
    }
}

gadgets {
    Spi {
        spi("api")
        compile()
    }
}

dependencies {
    implementation(libs.androidx.startup)
}