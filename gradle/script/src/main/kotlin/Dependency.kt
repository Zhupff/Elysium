import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.dsl.DependencyHandler

class Dependency<S : Script> internal constructor(
    val script: S,
) {

    init {
        script.dependency = this
    }

    private val project: Project = script.project

    private val libs: VersionCatalog = project.libs

    private val dependencies: DependencyHandler = project.dependencies

    private fun project(name: String): Project = project.rootProject.findProject(name)!!

    fun common() {
        dependencies.apply {
            add("implementation", libs.findLibrary("androidx-core-ktx").get())
            add("implementation", libs.findLibrary("androidx-appcompat").get())
        }
    }

    fun basic(
        closure: Basic.() -> Unit = {}
    ) {
        dependencies.add("implementation", project(":basic"))
        Basic().closure()
    }


    inner class Basic internal constructor() {
    }
}


fun <S : Script> S.dependency(
    closure: Dependency<S>.() -> Unit = {},
) {
    (dependency as? Dependency<S> ?: Dependency(this)).closure()
}