plugins {
    kotlin("multiplatform")
    id("jacoco")
    id("maven-publish")
    id("com.jfrog.bintray")
    id("com.github.b3er.local.properties") version "1.1"
}

kotlin {
    metadata { mavenPublication { artifactId = "unoxcore-jvm-metadata" } }

    jvm {
        mavenPublication { artifactId = "unoxcore-jvm" }
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    @Suppress("UNUSED_VARIABLE")
    sourceSets {
        val jvmMain by getting {
            kotlin.srcDir("src/main/kotlin")
            dependencies {
                //Libs here
            }
        }

        val jvmTest by getting {
            kotlin.srcDir("src/test/kotlin")
            dependencies {
                TestDeps.core.forEach(::implementation)
            }
        }
    }
}

setupJacoco {
    sourceDirectories.setFrom(files(
            "src/main/kotlin"
    ))
}

setupBintrayPublish(bintray, "metadata", "jvm")