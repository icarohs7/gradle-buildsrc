plugins {
    `kotlin-dsl`
}

dependencies {
    val gradlePluginVersion = "3.4.0"
    val kotlinVersion = "1.3.30"
    val navigationVersion = "2.0.0"
    val googleServicesVersion = "4.2.0"
    val bintrayPluginVersion = "1.8.4"

    compileOnly(gradleApi())
    implementation("com.android.tools.build:gradle:$gradlePluginVersion")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
    implementation("org.jetbrains.kotlin:kotlin-serialization:$kotlinVersion")
    implementation("androidx.navigation:navigation-safe-args-gradle-plugin:$navigationVersion")
    implementation("com.google.gms:google-services:$googleServicesVersion")
    implementation("com.jfrog.bintray.gradle:gradle-bintray-plugin:$bintrayPluginVersion")
}

repositories {
    google()
    jcenter()
    gradlePluginPortal()
}