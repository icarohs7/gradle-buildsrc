import org.gradle.api.Project
import org.gradle.api.artifacts.Dependency
import org.gradle.kotlin.dsl.project

fun Project.res(resModuleName: String): Dependency = when {
    this.hasProperty("relativeResMod") -> {
        dependencies.project(":${resModuleName}resources")
    }
    else -> {
        dependencies.project(":resmodules:${resModuleName}resources")
    }
}