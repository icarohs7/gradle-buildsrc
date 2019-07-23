import org.gradle.api.Project
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


fun Project.findProp(s: String) = project.findProperty(s) as String

fun Project.uniqueName(rootProject: Project): String = "${rootProject.name}$path"

fun Project.compileKotlinToJvmVersion(jvmTarget: String) {
    tasks.withType<KotlinCompile> {
        kotlinOptions.jvmTarget = jvmTarget
    }
}

fun Project.useExperimentalFeatures(usedExperimentalMarkers: List<String> = emptyList()) {
    tasks.withType<KotlinCompile>().all {
        kotlinOptions.freeCompilerArgs += listOf(
                "-Xuse-experimental=kotlin.Experimental",
                "-Xuse-experimental=kotlinx.coroutines.ExperimentalCoroutinesApi"
        ) + usedExperimentalMarkers
    }
}