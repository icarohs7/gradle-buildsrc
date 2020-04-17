import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.get
import java.io.File
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
        }
    }
}

var Project.applicationId: String
    @Deprecated("No Getter", level = DeprecationLevel.ERROR) get() = error("No Getter")
    set(value) {
        extensions.configure<AndroidBlock>("android") {
            defaultConfig {
                applicationId = value
            }
        }
    }

internal fun Project.configureDefaultAndroid() {
    compileKotlin {
        useExperimentalFeatures()
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }

    extensions.configure<AndroidBlock>("android") {
        sourceSets["main"].java.srcDir("src/main/kotlin")
        sourceSets["test"].java.srcDir("src/test/kotlin")

        compileSdkVersion(29)

        defaultConfig {
            //            javaCompileOptions {
            //                annotationProcessorOptions {
            //                    arguments.plusAssign(mapOf(
            //                            "room.incremental" to "true"
            //                    ))
            //                }
            //            }
            minSdkVersion(21)
            targetSdkVersion(29)
            //            testInstrumentationRunnerArguments.plusAssign("clearPackageData" to "true")
            versionCode = 1
            versionName = "1.0"
        }

        buildTypes {
            getByName("debug") {
                isTestCoverageEnabled = project.hasProperty("coverage") == true
            }
            getByName("release") {
                isMinifyEnabled = false
                proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
            }
        }

        dataBinding.isEnabled = true

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }

        configureTests()

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
}

private fun AndroidBlock.configureTests() {
    testOptions {
        //            execution = "ANDROIDX_TEST_ORCHESTRATOR"
        unitTests.apply {
            isIncludeAndroidResources = true
            isReturnDefaultValues = true

            //            all(closureOf<Test> {
            //                testLogging {
            //                    events(TestLogEvent.PASSED, TestLogEvent.SKIPPED, TestLogEvent.FAILED)
            //                    exceptionFormat = TestExceptionFormat.FULL
            //                }
            //            }) TODO re-enable when fixed on gradle
        }
    }
}
