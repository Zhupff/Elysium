import Configuration.AndroidConfiguration.ApplicationConfiguration
import Configuration.AndroidConfiguration.LibraryConfiguration
import Configuration.JvmConfiguration
import org.gradle.api.JavaVersion
import org.gradle.api.plugins.JavaPluginExtension

abstract class Configuration<S : Script> internal constructor(
    val script: S
) {
    init {
        script.configuration = this
    }

    abstract fun configure()


    abstract class AndroidConfiguration<S : Script> internal constructor(
        script: S,
        val namespace: String,
    ) : Configuration<S>(
        script,
    ) {

        override fun configure() {
            with(script.project) {
                androidExtension.apply {
                    namespace = this@AndroidConfiguration.namespace
                    compileSdk = 33
                    defaultConfig {
                        minSdk = 24
                    }
                    compileOptions {
                        sourceCompatibility = JavaVersion.VERSION_17
                        targetCompatibility = JavaVersion.VERSION_17
                    }
                    kotlinOptions {
                        jvmTarget = JavaVersion.VERSION_17.toString()
//                        freeCompilerArgs = freeCompilerArgs + listOf(
//                            "-module-name",
//                            project.path.replaceFirst(":", "").replace(":", "-")
//                        )
                    }
                    packaging {
                        resources {
                            excludes += "/META-INF/{AL2.0,LGPL2.1}"
                        }
                    }
                    viewBinding {
                        enable = true
                    }
                }
            }
        }


        class ApplicationConfiguration(
            script: ApplicationScript,
            namespace: String,
        ) : AndroidConfiguration<ApplicationScript>(
            script,
            namespace,
        ) {
            override fun configure() {
                super.configure()
                with(script.project) {
                    applicationExtension.apply {
                        defaultConfig {
                            applicationId = this@ApplicationConfiguration.namespace
                            versionName = ELYSIUM_VERSION
                            println("applicationId=$applicationId, versionName=$versionName")
                        }
                    }
                }
            }
        }


        class LibraryConfiguration(
            script: LibraryScript,
            namespace: String,
        ) : AndroidConfiguration<LibraryScript>(
            script,
            namespace,
        ) {
        }
    }


    class JvmConfiguration(
        script: JvmScript,
    ) : Configuration<JvmScript>(
        script,
    ) {
        override fun configure() {
            script.project.extensions.getByType(JavaPluginExtension::class.java).apply {
                sourceCompatibility = JavaVersion.VERSION_17
                targetCompatibility = JavaVersion.VERSION_17
            }
        }
    }
}


fun ApplicationScript.configuration(
    namespace: String,
    closure: ApplicationConfiguration.() -> Unit = {},
) {
    (configuration as? ApplicationConfiguration ?: ApplicationConfiguration(this, namespace)).closure()
}

fun LibraryScript.configuration(
    namespace: String,
    closure: LibraryConfiguration.() -> Unit = {},
) {
    (configuration as? LibraryConfiguration ?: LibraryConfiguration(this, namespace)).closure()
}

fun JvmScript.configuration(
    closure: JvmConfiguration.() -> Unit = {},
) {
    (configuration as? JvmConfiguration ?: JvmConfiguration(this)).closure()
}