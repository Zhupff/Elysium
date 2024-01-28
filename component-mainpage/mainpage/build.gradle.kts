plugins {
    id("com.elysium.library")
}

script {
    configuration("com.elysium.mainpage") {
        configure()
    }
    dependency {
        basic()
        common()
        component("mainpage")
    }
}