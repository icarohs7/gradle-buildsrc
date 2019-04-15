import com.jfrog.bintray.gradle.BintrayExtension
import org.gradle.api.Action
import org.gradle.api.Project
import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.delegateClosureOf
import org.gradle.kotlin.dsl.withType
import com.android.build.gradle.LibraryExtension as AndroidBlock

fun Project.setupBintrayPublish(
        bintrayExtension: BintrayExtension,
        vararg publications: String = arrayOf(""),
        pomBlock: MavenPublication.() -> Unit = {},
        block: BintrayExtension.() -> Unit = {}
): Unit = with(bintrayExtension) {
    try {
        user = project.findProp("bintray_user")
        key = project.findProp("bintray_api_key")
    } catch (e: TypeCastException) {
        return@with
    }
    publish = true
    override = true

    configure<PublishingExtension> {
        this.publications.withType<MavenPublication>().all(Action { setupPom(project); pomBlock() })
    }

    setPublications(*publications)
    pkg {
        desc = findProp("description")
        name = findProp("library_name")
        repo = findProp("repository")
        githubRepo = findProp("githubRepo")
        websiteUrl = findProp("websiteUrl")
        vcsUrl = findProp("vcsUrl")
        issueTrackerUrl = findProp("issueTrackerUrl")
        publicDownloadNumbers = true
        setLabels("kotlin")
        setLicenses("MIT")
    }

    block()
}

fun BintrayExtension.pkg(block: BintrayExtension.PackageConfig.() -> Unit) {
    pkg(delegateClosureOf(block))
}

fun MavenPublication.setupPom(project: Project) = pom {
    name.set(project.findProp("name"))
    description.set(project.findProp("description"))
    url.set(project.findProp("websiteUrl"))
    licenses {
        license {
            name.set("MIT License")
            url.set("http://www.opensource.org/licenses/mit-license.php")
        }
    }
    developers {
        developer {
            id.set("icarohs7")
            name.set("Icaro R D Temponi")
            email.set("icarohs7@gmail.com")
        }
    }
    scm {
        connection.set(project.findProp("vcsUrl"))
        developerConnection.set(project.findProp("vcsUrl"))
        url.set(project.findProp("websiteUrl"))
    }
}