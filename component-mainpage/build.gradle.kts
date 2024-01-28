plugins {
    id("com.elysium.library")
}

script {
    configuration("com.elysium.component.mainpage") {
        configure()
    }
    dependency {
        basic()
    }
}