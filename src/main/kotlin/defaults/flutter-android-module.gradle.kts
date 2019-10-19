package defaults

import com.android.build.gradle.TestedExtension as Android
import configureDefaultAndroid
import java.util.Properties

val localProperties = Properties()
val localPropertiesFile = rootProject.file("local.properties")
if (localPropertiesFile.exists()) localProperties.load(localPropertiesFile.reader())

val flutterRoot = localProperties.getProperty("flutter.sdk")
if (flutterRoot == null) {
    throw GradleException("Flutter SDK not found. Define location with flutter.sdk in the local.properties file.")
}

val flutterVersionCode = localProperties.getProperty("flutter.versionCode") ?: "1"
val flutterVersionName = localProperties.getProperty("flutter.versionName") ?: "1.0"

apply(plugin = "kotlin-android")
apply(from = "$flutterRoot/packages/flutter_tools/gradle/flutter.gradle")

configureDefaultAndroid()
extensions.configure<Android>("android") {
    lintOptions {
        disable.add("InvalidPackage")
    }

    defaultConfig {
        versionCode = flutterVersionCode.toInt()
        versionName = flutterVersionName
    }
}

withGroovyBuilder {
    "flutter" {
        setProperty("source", "../..")
    }
}

dependencies {
    "implementation"(Deps.kotlinStdLib)
}