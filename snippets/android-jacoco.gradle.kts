//TODO android { buildTypes { getByName("debug") { isTestCoverageEnabled = true } } }
//TODO plugin id("jacoco")

jacoco {
    toolVersion = "0.8.3"
}

tasks {
    withType<Test> {
        extensions.getByType<JacocoTaskExtension>().setIncludeNoLocationClasses(true)
    }

    create<JacocoReport>("jacocoTestReport") {
        dependsOn("testDebugUnitTest", "createDebugCoverageReport")

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
                fileTree("$buildDir/intermediates/classes/debug").exclude(excludes),
                fileTree("$buildDir/tmp/kotlin-classes/debug").exclude(excludes)
        )
        sourceDirectories.setFrom(files(
                android.sourceSets["main"].java.srcDirs,
                "src/main/kotlin"
        ))
        executionData("$buildDir/jacoco/testDebugUnitTest.exec")
    }
}