plugins {
    `kotlin-dsl`
}

dependencies {
    val gradlePluginVersion = "4.0.0-alpha01"
    val kotlinVersion = "1.3.60-eap-25"
    val navigationVersion = "2.2.0-alpha01"
    val googleServicesVersion = "4.3.1"
    val bintrayPluginVersion = "1.8.4"
    val versionsPluginVersion = "0.22.0"
    val gradleGithubPluginVersion = "4.1.1"
    val apolloGradlePluginVersion = "1.2.0-SNAPSHOT"
    val localPropertiesPluginVersion = "1.1"

    implementation(gradleApi())

    //id("com.android.application") || id("com.android.library")
    implementation("com.android.tools.build:gradle:$gradlePluginVersion")

    //id("kotlin-android")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")

    //id("kotlinx-serialization")
    implementation("org.jetbrains.kotlin:kotlin-serialization:$kotlinVersion")

    //id("androidx.navigation.safeargs.kotlin")
    implementation("androidx.navigation:navigation-safe-args-gradle-plugin:$navigationVersion")

    //Use on last line of buildscript file
    //apply(plugin = "com.google.gms.google-services")
    implementation("com.google.gms:google-services:$googleServicesVersion")

    //id("com.jfrog.bintray")
    implementation("com.jfrog.bintray.gradle:gradle-bintray-plugin:$bintrayPluginVersion")

    //id("com.github.ben-manes.versions")
    implementation("com.github.ben-manes:gradle-versions-plugin:$versionsPluginVersion")

    //id("io.freefair.github.base")
    //id("io.freefair.github.pom")
    //id("io.freefair.github.package-registry-maven-publish")
    //    implementation("io.freefair.gradle:github-plugin:$gradleGithubPluginVersion")

    //id("com.apollographql.apollo")
    implementation("com.apollographql.apollo:apollo-gradle-plugin-incubating:$apolloGradlePluginVersion")

    //id("com.github.b3er.local.properties")
    implementation("gradle.plugin.com.github.b3er.local.properties" +
            ":local-properties-plugin" +
            ":$localPropertiesPluginVersion")
}

repositories {
    google()
    gradlePluginPortal()
    maven("https://oss.sonatype.org/content/repositories/snapshots/")
    maven("https://dl.bintray.com/kotlin/kotlin-eap")
    jcenter()
}