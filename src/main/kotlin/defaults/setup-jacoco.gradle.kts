package defaults

import setupJacoco
import com.android.build.gradle.TestedExtension as AndroidBlock

plugins {
    id("jacoco")
}

setupJacoco {
    val androidBlock = extensions.findByType<AndroidBlock>()

    if (androidBlock != null) {
        sourceDirectories.setFrom(files(
                androidBlock.sourceSets["main"].java.srcDirs,
                "src/main/kotlin"
        ))
    } else {
        sourceDirectories.setFrom(files(
                "src/main/kotlin"
        ))
    }
}