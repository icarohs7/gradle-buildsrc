package defaults

dependencies {
    val add = { type: String, dependencies: List<String> -> dependencies.forEach { add(type, it) } }

    add("testImplementation", TestDeps.androidCore)
    add("androidTestImplementation", AndroidTestDeps.core)
    add("androidTestUtil", AndroidTestDeps.testOrchestrator)
    add("androidTestImplementation", AndroidTestDeps.barista) {
        exclude(group = "com.android.support")
        exclude(group = "org.jetbrains.kotlin")
    }
}