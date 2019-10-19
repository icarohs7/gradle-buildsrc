package defaults

plugins {
    id("defaults.root-module")
}

rootProject.buildDir = file("../build")
subprojects { project.buildDir = file("${rootProject.buildDir}/${project.name}") }
subprojects { project.evaluationDependsOn(":app") }