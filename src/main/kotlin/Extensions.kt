import org.gradle.api.Project
import org.gradle.api.initialization.Settings
import org.gradle.api.tasks.Delete
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.get
import org.gradle.kotlin.dsl.repositories
import org.gradle.kotlin.dsl.withGroovyBuilder
import java.io.File
import java.util.Properties
import com.android.build.gradle.AppExtension as AndroidApplicationBlock
import com.android.build.gradle.TestedExtension as AndroidBlock

fun Project.addReleaseCertificate(
        storeFilePath: String,
        storePassword: String,
        keyAlias: String,
        keyPassword: String
) {
    extensions.configure<AndroidBlock>("android") {
        signingConfigs {
            create("release") {
                this.storeFile = File("${project.rootProject.rootDir}/$storeFilePath")
                this.storePassword = storePassword
                this.keyAlias = keyAlias
                this.keyPassword = keyPassword
            }
        }

        buildTypes {
            getByName("release") {
                signingConfig = signingConfigs["release"]
            }
        }
    }
}

fun Project.enableProguard() {
    extensions.configure<AndroidBlock>("android") {
        buildTypes {
            getByName("release") {
                isMinifyEnabled = true
                isShrinkResources = true
                proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
            }
        }
    }
}

fun readPropertiesFile(file: File): Properties {
    return Properties().apply {
        load(file.reader(Charsets.UTF_8))
    }
}

fun Project.setupFlutterAndroidModuleSettings(localProperties: Properties, appId: String) {
    val flutterVersionCode = localProperties.getProperty("flutter.versionCode") ?: "1"
    val flutterVersionName = localProperties.getProperty("flutter.versionName") ?: "1.0"

    extensions.configure<AndroidBlock>("android") {
        compileSdkVersion(Versions.compileSdk)
        sourceSets["main"].java.srcDir("src/main/kotlin")
        sourceSets["test"].java.srcDir("src/test/kotlin")

        lintOptions {
            disable("InvalidPackage")
        }

        defaultConfig {
            minSdkVersion(Versions.minSdk)
            targetSdkVersion(Versions.targetSdk)
            applicationId = appId
            versionCode = flutterVersionCode.toInt()
            versionName = flutterVersionName
            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }
    }

    withGroovyBuilder {
        "flutter" {
            setProperty("source", "../..")
        }
    }

    DependencyHandlerScope.of(dependencies).apply {
        "implementation"(Deps.kotlinStdLib)
        "testImplementation"(TestDeps.junit)
        "androidTestImplementation"(AndroidTestDeps.testRunner)
        "androidTestImplementation"(AndroidTestDeps.espressoCore)
    }
}

fun Settings.setupFlutterSettings() {
    val flutterProjectRoot: File = rootProject.projectDir.parentFile
    val pluginsFile = flutterProjectRoot.resolve(".flutter-plugins")
    val plugins = readPropertiesFile(pluginsFile)
    plugins.map { Pair("${it.key}", "${it.value}") }.forEach { (name, path) ->
        val pluginDirectory = flutterProjectRoot.resolve(path).resolve("android")
        include(":$name")
        project(":$name").projectDir = pluginDirectory
    }
}

fun Project.setupFlutterRootProject() {
    allprojects {
        repositories {
            google()
            mavenCentral()
            maven("https://dl.bintray.com/kotlin/kotlin-eap")
            jcenter()
        }
    }
    rootProject.buildDir = file("../build")
    subprojects {
        project.buildDir = file("${rootProject.buildDir}/${project.name}")
    }
    subprojects {
        project.evaluationDependsOn(":app")
    }
    tasks.maybeCreate("clean", Delete::class.java).apply {
        doLast { delete(rootProject.buildDir) }
    }
}