plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlinx-serialization")
    id("androidx.navigation.safeargs.kotlin")
    defaults.`android-module`
}

android {
    defaultSettings()
    defaultConfig {
        applicationId = "com.company.appname"
        versionCode = 1
        versionName = "1.00"
    }
}

dependencies {
    defaultDependencies()
    AndroidKaptDeps.core.forEach(::kapt)
}