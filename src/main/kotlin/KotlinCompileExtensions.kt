import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.plugin.mpp.AbstractKotlinCompilation

fun AbstractKotlinCompilation<*>.setupMetaInfoName(rootProject: Project, project: Project) {
    val fileName = "${rootProject.name}${project.path}".replace(":", "_")
    kotlinOptions.freeCompilerArgs += listOf("-module-name", fileName)
}