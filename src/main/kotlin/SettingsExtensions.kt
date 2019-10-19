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
    val flutterProjectRoot: java.nio.file.Path = rootProject.projectDir.parentFile.toPath()
    val plugins = Properties()
    val pluginsFile = File(flutterProjectRoot.toFile(), ".flutter-plugins")
    if (pluginsFile.exists()) plugins.load(pluginsFile.reader())

    plugins.forEach { name, path ->
        path as String
        val pluginDirectory = flutterProjectRoot.resolve(path).resolve("android").toFile()
        include(":$name")
        project(":$name").projectDir = pluginDirectory
    }
}