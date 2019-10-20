plugins {
    id("com.android.application")
    id("kotlin-android")
    id("defaults.flutter-android-module")
}

android {
    applicationId = "company.appName" //TODO full app name here
}

dependencies {
    implementation(Deps.kotlinStdLib)
}