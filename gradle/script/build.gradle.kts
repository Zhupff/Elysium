plugins {
    `kotlin-dsl`
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    compileOnly(libs.android.gradle.plugin)
    compileOnly(libs.kotlin.gradle.plugin)
    compileOnly(libs.ksp.gradle.plugin)
}

gradlePlugin {
    plugins {
        register("ApplicationScript") {
            id = "com.elysium.application"
            implementationClass = "ApplicationScript"
        }
        register("LibraryScript") {
            id = "com.elysium.library"
            implementationClass = "LibraryScript"
        }
        register("JvmScript") {
            id = "com.elysium.jvm"
            implementationClass = "JvmScript"
        }
    }
}