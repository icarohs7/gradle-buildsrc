import org.gradle.api.JavaVersion
import com.android.build.gradle.TestedExtension as AndroidBlock
import org.gradle.api.artifacts.dsl.DependencyHandler as DependenciesBlock
import org.gradle.kotlin.dsl.PluginDependenciesSpecScope as PluginsBlock

fun AndroidBlock.defaultSettings() {
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
    }
}

var AndroidBlock.facebookAppId: String
    get() = defaultConfig.manifestPlaceholders["facebookAppId"]?.toString().orEmpty()
    set(value) {
        defaultConfig.manifestPlaceholders["facebookAppId"] = value
    }