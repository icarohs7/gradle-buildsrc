plugins {
    `kotlin-dsl`
}

dependencies {
    val gradlePluginVersion = "3.5.1"
    val kotlinVersion = "1.3.50"
    val googleServicesVersion = "4.3.1"
    val versionsPluginVersion = "0.22.0"

    implementation(gradleApi())

    //id("com.android.application") || id("com.android.library")
    implementation("com.android.tools.build:gradle:$gradlePluginVersion")

    //id("kotlin-android")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")

    //Use on last line of buildscript file
    //apply(plugin = "com.google.gms.google-services")
    implementation("com.google.gms:google-services:$googleServicesVersion")
}

repositories {
    google()
    gradlePluginPortal()
    maven("https://oss.sonatype.org/content/repositories/snapshots/")
    jcenter()
}