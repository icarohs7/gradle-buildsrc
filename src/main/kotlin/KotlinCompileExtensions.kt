import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.dsl.KotlinCompile
import org.jetbrains.kotlin.gradle.plugin.mpp.AbstractKotlinCompilation

fun AbstractKotlinCompilation<*>.setupMetaInfoName(rootProject: Project, project: Project) {
    val fileName = "${rootProject.name}${project.path}".replace(":", "_")
    kotlinOptions.freeCompilerArgs += listOf("-module-name", fileName)
}

/**
 * Remove warning from many experimental features usages
 */
fun KotlinCompile<*>.useExperimentalFeatures(usedExperimentalMarkers: List<String> = emptyList()) {
    kotlinOptions.freeCompilerArgs += listOf(
        "-Xuse-experimental=kotlin.Experimental",
        "-Xuse-experimental=kotlinx.coroutines.FlowPreview",
        "-Xuse-experimental=kotlinx.coroutines.ExperimentalCoroutinesApi",
        "-Xuse-experimental=kotlin.time.ExperimentalTime",
        "-Xuse-experimental=io.ktor.locations.KtorExperimentalLocationsAPI"
    ) + usedExperimentalMarkers
}