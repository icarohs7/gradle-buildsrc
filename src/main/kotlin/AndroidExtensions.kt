import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.get
import java.io.File
import com.android.build.gradle.AppExtension as AndroidApplicationBlock
import com.android.build.gradle.TestedExtension as AndroidBlock

fun AndroidBlock.addReleaseCertificate(
        project: Project,
        storeFilePath: String,
        storePassword: String,
        keyAlias: String,
        keyPassword: String
) {
    signingConfigs {
        create("release") {
            this.storeFile = File("${project.rootProject.rootDir}/$storeFilePath")
            this.storePassword = storePassword
            this.keyAlias = keyAlias
            this.keyPassword = keyPassword
        }
    }

    buildTypes {
        getByName("release") {
            signingConfig = signingConfigs["release"]
        }
    }
}

fun AndroidApplicationBlock.enableProguard() {
    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
        }
    }
}