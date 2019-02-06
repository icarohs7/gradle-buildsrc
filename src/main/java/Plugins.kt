/**
 * Object used to store snippets to plugin
 * applications using the plugins dsl
 */
object Plugins {
    const val kotlinJvm = """{id("org.jetbrains.kotlin.jvm") version "1.3.11"}"""
    const val shadowJar = """{id("com.github.johnrengelman.shadow") version "4.0.3"}"""
    const val gradleLatestVersions = """{id("com.github.ben-manes.versions") version "0.20.0"}"""
    const val kotlinxSerialization = """
        buildscript {
            dependencies {
                classpath("org.jetbrains.kotlin:kotlin-serialization:${Versions.kotlin}")
            }
        }
        
        plugins {
           id("kotlinx-serialization")
        }
        """
    const val navigationComponent = """
        buildscript {
            dependencies {
                classpath("android.arch.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}")
            }
        }

        plugins {
            id("androidx.navigation.safeargs.kotlin")
        }
    """
}