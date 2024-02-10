plugins {
    id("com.elysium.application")
}

script {
    configuration("com.elysium") {
        configure()
    }
    dependency {
        basic {
            url()
        }
        common()
        component("mainpage") {
            sub("mainpage")
        }
    }
}