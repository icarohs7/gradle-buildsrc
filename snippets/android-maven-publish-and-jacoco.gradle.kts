import com.jfrog.bintray.gradle.BintrayExtension

plugins {
    id("jacoco")
    id("maven-publish")
    id("com.jfrog.bintray") version "1.8.4"
    id("com.github.b3er.local.properties") version "1.1"
}

with(project) {
    group = "com.github.icarohs7"
    version = "3.00"
    description = "Library aggregating extensions, utility functions and some QOL features"
}

jacoco {
    toolVersion = "0.8.3"
}

tasks {
    withType<Test> {
        extensions.getByType<JacocoTaskExtension>().setIncludeNoLocationClasses(true)
    }

    create<JacocoReport>("jacocoTestReport") {
        dependsOn("testDebugUnitTest", "check", "createDebugCoverageReport")

        this.group = "Reporting"
        this.description = "Generate Jacoco coverage reports for Debug build"

        reports {
            xml.isEnabled = true
            html.isEnabled = true
        }

        val excludes = listOf(
                "**/R.class",
                "**/R\$*.class",
                "**/*\$ViewInjector*.*",
                "**/BuildConfig.*",
                "**/Manifest*.*",
                "**/*Test*.*",
                "android/**/*.*"
        )

        classDirectories.setFrom(
                fileTree("$buildDir/intermediates/classes/debug") { exclude(excludes) },
                fileTree("$buildDir/tmp/kotlin-classes/debug") { exclude(excludes) }
        )
        sourceDirectories.setFrom(files(
                android.sourceSets["main"].java.srcDirs,
                "src/main/kotlin"
        ))

        executionData("$buildDir/jacoco/testDebugUnitTest.exec")
        executionData("$buildDir/jacoco/jvmTest.exec")
    }
}

fun findProperty(s: String) = project.findProperty(s) as String?
bintray {
    user = findProperty("bintrayUser")
    key = findProperty("bintrayApiKey")
    publish = true
    setPublications("js", "jvm", "androidDebug")
    pkg(delegateClosureOf<BintrayExtension.PackageConfig> {
        repo = "libraries"
        name = "unox-core"
        githubRepo = "icarohs7/unox-core"
        vcsUrl = "https://github.com/icarohs7/unox-core.git"
        setLabels("kotlin")
        setLicenses("MIT")
        desc = description
    })
}