package defaults

allprojects {
    repositories {
        google()
        mavenLocal()
        mavenCentral()
        maven("http://devrepo.kakao.com:8088/nexus/content/groups/public/")
        maven("https://kotlin.bintray.com/kotlinx")
        maven("https://jitpack.io")
        maven("https://oss.sonatype.org/content/repositories/snapshots/")
        jcenter()
    }
}

task<Delete>("clean") {
    delete(rootProject.buildDir)
}