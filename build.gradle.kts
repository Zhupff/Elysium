buildscript {
    dependencies {
        classpath(libs.gadget)
        classpath(libs.gadgetBasic)
        classpath(libs.gadgetBlur)
        classpath(libs.gadgetLogger)
        classpath(libs.gadgetMedia)
        classpath(libs.gadgetSpi)
        classpath(libs.gadgetTheme)
        classpath(libs.gadgetToast)
        classpath(libs.gadgetWidget)
    }
}
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.kotlin.kapt) apply false
    alias(libs.plugins.kotlin.ksp) apply false
}