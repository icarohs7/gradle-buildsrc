import groovy.lang.Closure
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.tasks.testing.Test
import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent
import org.gradle.kotlin.dsl.get
import java.io.File
import com.android.build.gradle.AppExtension as AndroidApplicationBlock
import com.android.build.gradle.TestedExtension as AndroidBlock

fun AndroidBlock.defaultSettings(project: Project? = null) {
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
            isTestCoverageEnabled = project?.hasProperty("coverage") == true
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
            all(object : Closure<Test>(this, this) {
                @Suppress("unused") // Called by groovy's dark magic
                fun doCall(test: Test): Unit = with(test) {
                    testLogging {
                        events(TestLogEvent.PASSED, TestLogEvent.SKIPPED, TestLogEvent.FAILED)
                        exceptionFormat = TestExceptionFormat.FULL
                    }
                }
            })
        }
    }

    lintOptions {
        isAbortOnError = false
        isCheckReleaseBuilds = false
    }

    packagingOptions {
        pickFirst("META-INF/library_release.kotlin_module")
        pickFirst("META-INF/lib_release.kotlin_module")
        pickFirst("META-INF/atomicfu.kotlin_module")
        pickFirst("META-INF/kotlinx-coroutines-core.kotlin_module")
        pickFirst("META-INF/unox-core_shared.kotlin_module")
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

var AndroidBlock.facebookAppId: String
    get() = defaultConfig.manifestPlaceholders["facebookAppId"]?.toString().orEmpty()
    set(value) {
        defaultConfig.manifestPlaceholders["facebookAppId"] = value
    }

fun AndroidApplicationBlock.enableProguard() {
    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
        }
    }
}