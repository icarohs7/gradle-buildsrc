plugins {
    `kotlin-dsl`
}

dependencies {
    val gradlePluginVersion = "3.3.2"
    val kotlinVersion = "1.3.21"
    val navigationVersion = "2.0.0"
    val googleServicesVersion = "4.2.0"

    compileOnly(gradleApi())
    implementation("com.android.tools.build:gradle:$gradlePluginVersion")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
    implementation("org.jetbrains.kotlin:kotlin-serialization:$kotlinVersion")
    implementation("androidx.navigation:navigation-safe-args-gradle-plugin:$navigationVersion")
    implementation("com.google.gms:google-services:$googleServicesVersion")
}

repositories {
    google()
    jcenter()
}