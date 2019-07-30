package defaults

allprojects {
    repositories {
        google()
        mavenLocal()
        mavenCentral()
        maven("https://kotlin.bintray.com/kotlinx")
        maven("https://oss.sonatype.org/content/repositories/snapshots/")
        maven("https://dl.bintray.com/icarohs7/libraries")
        jcenter()
        maven("https://jitpack.io")
    }
}

tasks.maybeCreate<Delete>("clean").apply {
    doLast { delete(rootProject.buildDir) }
}