plugins {
    `maven-publish`
}

afterEvaluate {
    tasks {
        withType<Javadoc> {
            isEnabled = false
        }
    }
}

fun MavenPublication.setupPom(group: String, artifact: String, versionName: String): Unit = pom {
    groupId = group
    artifactId = artifact
    version = versionName
}
