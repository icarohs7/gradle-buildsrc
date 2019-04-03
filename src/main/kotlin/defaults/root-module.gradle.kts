package defaults

allprojects {
    repositories {
        google()
        maven("http://devrepo.kakao.com:8088/nexus/content/groups/public/")
        maven("https://jitpack.io")
        maven("https://oss.sonatype.org/content/repositories/snapshots/")
        maven("https://kotlin.bintray.com/kotlinx")
        maven("https://dl.bintray.com/icarohs7/libraries")
        jcenter()
    }
}

task<Delete>("clean") {
    delete(rootProject.buildDir)
}