plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

dependencies {
    val kotlinVersion = "1.3.21"

    compileOnly(gradleApi())
    implementation("androidx.navigation:navigation-safe-args-gradle-plugin:2.0.0")
    implementation("com.android.tools.build:gradle:3.3.2")
    implementation("com.google.gms:google-services:4.2.0")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
    implementation("org.jetbrains.kotlin:kotlin-serialization:$kotlinVersion")
}

repositories {
    google()
    jcenter()
}