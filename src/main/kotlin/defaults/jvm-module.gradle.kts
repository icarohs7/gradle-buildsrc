package defaults

import TestDeps

dependencies {
    val add = { type: String, dependencies: List<String> -> dependencies.forEach { add(type, it) } }

    add("testImplementation", TestDeps.core)
}