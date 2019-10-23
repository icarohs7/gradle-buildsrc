import org.gradle.api.Project
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.get
import org.gradle.kotlin.dsl.withGroovyBuilder
import java.io.File
import java.util.Properties
import com.android.build.gradle.AppExtension as AndroidApplicationBlock
import com.android.build.gradle.TestedExtension as AndroidBlock

fun AndroidBlock.addReleaseCertificate(
        project: Project,
        storeFilePath: String,
        storePassword: String,
        keyAlias: String,
        keyPassword: String
) {
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

fun AndroidApplicationBlock.enableProguard() {
    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
}

fun readPropertiesFile(file: File): Properties {
    return Properties().apply {
        load(file.reader(Charsets.UTF_8))
    }
}

fun Project.setupFlutterAndroidModuleSettings(localProperties: Properties) {
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