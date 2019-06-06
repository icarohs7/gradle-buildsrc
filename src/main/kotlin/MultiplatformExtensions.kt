import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

fun KotlinMultiplatformExtension.setupMetaInfoName(rootProject: Project, project: Project) {
    targets.all {
        compilations.all {
            val fileName = "${rootProject.name}${project.path}".replace(":", "_")
            kotlinOptions.freeCompilerArgs += listOf("-module-name", fileName)
        }
    }
}

fun KotlinMultiplatformExtension.setupMetadataTarget(rootProject: Project, project: Project, artifactId: String) {
    metadata { mavenPublication { this.artifactId = artifactId } }
}

fun KotlinMultiplatformExtension.setupAndroidTarget(
        rootProject: Project,
        project: Project,
        artifactId: String
) {
    android {
        mavenPublication { this.artifactId = artifactId }
        publishLibraryVariants("debug")
        compilations.all { kotlinOptions.jvmTarget = "1.6" }
    }
}
