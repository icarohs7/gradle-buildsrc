import org.gradle.api.initialization.Settings
import java.io.File
import java.util.Properties

fun Settings.setupKotlinSettings(version: String = Versions.kotlin) {
    pluginManagement {
        resolutionStrategy {
            eachPlugin {
                if (requested.id.id.startsWith("org.jetbrains.kotlin."))
                    useVersion(version)
            }
        }
    }
}

fun Settings.setupFlutterSettings() {
    apply(mapOf("from" to "$rootDir/buildSrc/groovy/flutter-settings-script.gradle"))
}