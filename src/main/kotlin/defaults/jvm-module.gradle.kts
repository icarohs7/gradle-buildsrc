package defaults

import TestDeps
import compileKotlin
import useExperimentalFeatures

compileKotlin {
    useExperimentalFeatures()
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    val add = { type: String, dependencies: List<String> -> dependencies.forEach { add(type, it) } }

    add("testImplementation", TestDeps.core)
}