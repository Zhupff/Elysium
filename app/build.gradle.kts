plugins {
    id("com.elysium.application")
}

script {
    configuration("com.elysium") {
        configure()
    }
    dependency {
        basic()
        common()
        component("mainpage") {
            sub("mainpage")
        }
    }
}