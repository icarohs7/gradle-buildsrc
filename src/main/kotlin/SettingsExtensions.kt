import org.gradle.kotlin.dsl.support.delegates.SettingsDelegate
 
fun SettingsDelegate.setKotlinPluginsVersion(version: String = Versions.kotlin) {
    pluginManagement {
        resolutionStrategy {
            eachPlugin {
                if (requested.id.id.startsWith("org.jetbrains.kotlin."))
                    useVersion(version)
            }
        }
    }
}