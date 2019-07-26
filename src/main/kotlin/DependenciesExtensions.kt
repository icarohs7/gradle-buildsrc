import org.gradle.api.artifacts.ProjectDependency
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.project

fun DependencyHandlerScope.res(resModuleName: String): ProjectDependency {
    return project(":resmodules:${resModuleName}resources")
}