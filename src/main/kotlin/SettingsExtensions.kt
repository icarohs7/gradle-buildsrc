import org.gradle.api.initialization.Settings

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