import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.dsl.KotlinCompile
import org.jetbrains.kotlin.gradle.plugin.mpp.AbstractKotlinCompilation

fun AbstractKotlinCompilation<*>.setupMetaInfoName(rootProject: Project, project: Project) {
    val fileName = "${rootProject.name}${project.path}".replace(":", "_")
    kotlinOptions.freeCompilerArgs += listOf("-module-name", fileName)
}

fun KotlinCompile<*>.useExperimentalFeatures(usedExperimentalMarkers: List<String> = emptyList()) {
    kotlinOptions.freeCompilerArgs += listOf(
            "-Xuse-experimental=kotlin.Experimental",
            "-Xuse-experimental=kotlinx.coroutines.ExperimentalCoroutinesApi"
    ) + usedExperimentalMarkers
}