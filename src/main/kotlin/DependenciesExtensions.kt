import org.gradle.api.Project
import org.gradle.api.artifacts.ProjectDependency
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.project

fun DependencyHandlerScope.res(resModuleName: String, project: Project? = null): ProjectDependency {
    return if (project?.hasProperty("relativeResMod") == true)
        project(":${resModuleName}resources")
    else
        project(":resmodules:${resModuleName}resources")
}