package defaults

allprojects {
    repositories {
        google()
        mavenLocal()
        mavenCentral()
        maven("http://devrepo.kakao.com:8088/nexus/content/groups/public/")
        maven("https://kotlin.bintray.com/kotlinx")
        maven("https://oss.sonatype.org/content/repositories/snapshots/")
        jcenter()
        maven("https://jitpack.io")
    }
}

task<Delete>("clean") {
    delete(rootProject.buildDir)
}