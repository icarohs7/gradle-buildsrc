package defaults

allprojects {
    repositories {
        google()
        mavenCentral()
        maven("http://devrepo.kakao.com:8088/nexus/content/groups/public/")
        maven("https://kotlin.bintray.com/kotlinx")
        maven("https://dl.bintray.com/icarohs7/libraries")
        maven("https://jitpack.io")
        maven("https://oss.sonatype.org/content/repositories/snapshots/")
        jcenter()
    }
}

task<Delete>("clean") {
    delete(rootProject.buildDir)
}