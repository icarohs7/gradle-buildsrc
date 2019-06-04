import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

fun KotlinMultiplatformExtension.setupMetadataTarget(artifactId: String) {
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
        compilations.all {
            setupMetaInfoName(rootProject, project)
            kotlinOptions.jvmTarget = "1.6"
        }
    }
}