import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.get
import java.io.File
import com.android.build.gradle.TestedExtension as AndroidBlock

fun AndroidBlock.defaultSettings() {
    sourceSets["main"].java.srcDir("src/main/kotlin")
    sourceSets["test"].java.srcDir("src/test/kotlin")

    compileSdkVersion(28)

    facebookAppId = ""
    defaultConfig {
        minSdkVersion(21)
        targetSdkVersion(28)
        testInstrumentationRunnerArguments.plusAssign("clearPackageData" to "true")
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        getByName("debug") {
            isTestCoverageEnabled = true
        }
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    dataBinding {
        isEnabled = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    testOptions {
        execution = "ANDROIDX_TEST_ORCHESTRATOR"
        unitTests.apply {
            isIncludeAndroidResources = true
            isReturnDefaultValues = true
        }
    }

    lintOptions {
        isAbortOnError = false
    }

    packagingOptions {
        pickFirst("META-INF/library_release.kotlin_module")
        pickFirst("META-INF/lib_release.kotlin_module")
        pickFirst("META-INF/atomicfu.kotlin_module")
        pickFirst("META-INF/kotlinx-coroutines-core.kotlin_module")
        pickFirst("META-INF/shared.kotlin_module")
    }
}

fun AndroidBlock.addReleaseCertificate(
        project: Project,
        storeFilePath: String,
        storePassword: String,
        keyAlias: String,
        keyPassword: String
) {
    signingConfigs {
        create("release") {
            this.storeFile = File("${project.rootProject.rootDir}/$storeFilePath.jks")
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

var AndroidBlock.facebookAppId: String
    get() = defaultConfig.manifestPlaceholders["facebookAppId"]?.toString().orEmpty()
    set(value) {
        defaultConfig.manifestPlaceholders["facebookAppId"] = value
    }