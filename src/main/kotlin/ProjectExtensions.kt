import org.gradle.api.Project

fun Project.findProp(s: String) = project.findProperty(s) as String

fun Project.nameWithPath(rootProject: Project): String = "${rootProject.name}$path"