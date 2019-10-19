plugins {
    id("com.android.application")
    id("kotlin-android")
    id("defaults.flutter-android-module")
}

android {
    dataBinding.isEnabled = false
    applicationId = "company.appName" //TODO full app name here
}

dependencies {
    implementation(Deps.kotlinStdLib)
}