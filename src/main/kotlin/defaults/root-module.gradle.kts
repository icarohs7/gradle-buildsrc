package defaults

import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask

allprojects {
    repositories {
        google()
        mavenLocal()
        mavenCentral()
        maven("https://kotlin.bintray.com/kotlinx")
        maven("https://oss.sonatype.org/content/repositories/snapshots/")
        maven("https://dl.bintray.com/icarohs7/libraries")
        maven("https://dl.bintray.com/excitement-engineer/ktor-graphql")
        maven("http://dl.bintray.com/apollographql/android")
        maven("https://dl.bintray.com/kotlin/kotlin-eap")
        jcenter()
        maven("https://jitpack.io")
    }
}

tasks.maybeCreate<Delete>("clean").apply {
    doLast { delete(rootProject.buildDir) }
}

tasks.withType<DependencyUpdatesTask> {
    fun isNonStable(version: String): Boolean {
        val stableKeyword = listOf("RELEASE", "FINAL", "GA").any { version.toUpperCase().contains(it) }
        val regex = "^[0-9,.v-]+(-r)?$".toRegex()
        val isStable = stableKeyword || regex.matches(version)
        return isStable.not()
    }
    resolutionStrategy {
        componentSelection {
            all {
                if (isNonStable(candidate.version)) {
                    reject("Non stable")
                }
            }
        }
    }
}