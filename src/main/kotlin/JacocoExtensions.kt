import org.gradle.api.Project
import org.gradle.api.tasks.testing.Test
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.create
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.invoke
import org.gradle.kotlin.dsl.withType
import org.gradle.testing.jacoco.plugins.JacocoPluginExtension
import org.gradle.testing.jacoco.plugins.JacocoTaskExtension
import org.gradle.testing.jacoco.tasks.JacocoReport

fun Project.setupJacocoMultimodule(block: JacocoReport.() -> Unit = {}): Unit = tasks {
    configure<JacocoPluginExtension> {
        toolVersion = Versions.jacoco
    }

    withType<Test> {
        extensions.getByType<JacocoTaskExtension>().setIncludeNoLocationClasses(true)
    }

    create<JacocoReport>("jacocoRootReport") {
        val subprojectsJacocoReportTasks = getTasksByName("jacocoTestReport", true).asSequence()
                .mapNotNull { it as? JacocoReport }.toList()

        dependsOn(subprojectsJacocoReportTasks)

        executionData.setFrom(subprojectsJacocoReportTasks.map { it.executionData })
        sourceDirectories.setFrom(subprojectsJacocoReportTasks.map { it.sourceDirectories })
        classDirectories.setFrom(subprojectsJacocoReportTasks.map { it.classDirectories })

        reports {
            xml.isEnabled = true
            html.isEnabled = true
        }
    }
}.let { Unit }

fun Project.setupJacoco(block: JacocoReport.() -> Unit = {}): Unit = tasks {
    configure<JacocoPluginExtension> {
        toolVersion = Versions.jacoco
    }

    withType<Test> {
        extensions.getByType<JacocoTaskExtension>().setIncludeNoLocationClasses(true)
    }

    create<JacocoReport>("jacocoTestReport") {
        val getTasks = { names: List<String> -> names.flatMap { name -> getTasksByName(name, true) } }
        dependsOn(getTasks(listOf("testDebugUnitTest", "check", "createDebugCoverageReport")))

        this.group = "Reporting"
        this.description = "Generate Jacoco coverage reports for build"

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
                fileTree("$buildDir/tmp/kotlin-classes/debug") { exclude(excludes) },
                fileTree("$buildDir/classes/kotlin/") { exclude(excludes) }
        )

        executionData.setFrom(
                fileTree("$buildDir/jacoco") { include("*.exec") }
        )

        block()
    }
}.let { Unit }