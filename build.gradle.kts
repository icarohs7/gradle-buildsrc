plugins {
    `kotlin-dsl`
}

dependencies {
    val gradlePluginVersion = "3.5.0"
    val kotlinVersion = "1.3.50"
    val navigationVersion = "2.2.0-alpha01"
    val googleServicesVersion = "4.2.0"
    val bintrayPluginVersion = "1.8.4"
    val versionsPluginVersion = "0.22.0"
    val localPropertiesPluginVersion = "1.1"
    val dependencyGraphGeneratorPluginVersion = "0.5.0"

    compileOnly(gradleApi())

    //id("com.android.application") || id("com.android.library")
    implementation("com.android.tools.build:gradle:$gradlePluginVersion")

    //id("kotlin-android")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")

    //id("kotlinx-serialization")
    implementation("org.jetbrains.kotlin:kotlin-serialization:$kotlinVersion")

    //id("androidx.navigation.safeargs.kotlin")
    implementation("androidx.navigation:navigation-safe-args-gradle-plugin:$navigationVersion")

    //apply(plugin = "com.google.gms.google-services") (last line of file)
    implementation("com.google.gms:google-services:$googleServicesVersion")

    //id("com.jfrog.bintray")
    implementation("com.jfrog.bintray.gradle:gradle-bintray-plugin:$bintrayPluginVersion")

    //id("com.github.ben-manes.versions")
    implementation("com.github.ben-manes:gradle-versions-plugin:$versionsPluginVersion")

    //id("com.github.b3er.local.properties")
    implementation("gradle.plugin.com.github.b3er.local.properties" +
            ":local-properties-plugin" +
            ":$localPropertiesPluginVersion")

    //id("com.vanniktech.dependency.graph.generator")
    implementation("gradle.plugin.com.vanniktech" +
            ":gradle-dependency-graph-generator-plugin" +
            ":$dependencyGraphGeneratorPluginVersion")
}

repositories {
    google()
    jcenter()
    gradlePluginPortal()
}