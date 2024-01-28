import org.gradle.api.Plugin
import org.gradle.api.Project

abstract class Script : Plugin<Project>, MutableMap<Any, Any> by HashMap() {

    val project: Project; get() = this[Project::class.java] as Project

    var configuration: Configuration<*>? = null
        get() = this[Configuration::class.java] as? Configuration<*>
        set(value) {
            if (field != null && field != value)
                throw IllegalArgumentException("Already set Configuration: $field")
            field = value
        }

    var dependency: Dependency<*>? = null
        get() = this[Dependency::class.java] as? Dependency<*>
        set(value) {
            if (field != null && field != value)
                throw IllegalArgumentException("Already set Dependency: $field")
            field = value
        }

    override fun apply(target: Project) {
        clear()
        this[Project::class.java] = target
    }
}


class ApplicationScript : Script() {

    override fun apply(target: Project) {
        super.apply(target)
        target.pluginManager.apply("com.android.application")
        target.pluginManager.apply("org.jetbrains.kotlin.android")
        target.pluginManager.apply("zhupf.gadgets")
        target.extensions.add(ApplicationScript::class.java, "script", this)
    }
}


class LibraryScript : Script() {

    override fun apply(target: Project) {
        super.apply(target)
        target.pluginManager.apply("com.android.library")
        target.pluginManager.apply("org.jetbrains.kotlin.android")
        target.pluginManager.apply("zhupf.gadgets")
        target.extensions.add(LibraryScript::class.java, "script", this)
    }
}


class JvmScript : Script() {

    override fun apply(target: Project) {
        super.apply(target)
        target.pluginManager.apply("org.jetbrains.kotlin.jvm")
        target.pluginManager.apply("zhupf.gadgets")
        target.extensions.add(JvmScript::class.java, "script", this)
    }
}