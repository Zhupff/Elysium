import zhupf.gadget.spi.Spi

plugins {
    id("com.elysium.library")
}

script {
    configuration("com.elysium.mainpage") {
        configure()
    }
    dependency {
        basic {
            url()
        }
        common()
        component("mainpage")
    }
}

gadgets {
    Spi {
        compile()
    }
}