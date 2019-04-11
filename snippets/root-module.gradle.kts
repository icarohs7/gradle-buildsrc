plugins {
    defaults.`root-module`
    id("com.github.ben-manes.versions") version "0.21.0"
}

tasks.create("genDatabindingClassesOnAllModules") {
    getTasksByName("dataBindingGenBaseClassesDebug", true).forEach { task ->
        dependsOn(task)
    }
}