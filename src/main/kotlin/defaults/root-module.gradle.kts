package defaults

allprojects {
    repositories {
        google()
        mavenLocal()
        mavenCentral()
        maven("https://kotlin.bintray.com/kotlinx")
        maven("https://oss.sonatype.org/content/repositories/snapshots/")
        maven("https://dl.bintray.com/icarohs7/libraries")
        maven("https://dl.bintray.com/excitement-engineer/ktor-graphql")
        maven("http://dl.bintray.com/apollographql/android")
        maven("https://dl.bintray.com/kotlin/kotlin-eap")
        jcenter()
        maven("https://jitpack.io")
    }
}

tasks.maybeCreate<Delete>("clean").apply {
    doLast { delete(rootProject.buildDir) }
}