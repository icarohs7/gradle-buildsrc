import org.gradle.api.Project
import org.gradle.jvm.tasks.Jar
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

fun Project.jar(block: Jar.() -> Unit) {
    tasks.withType<Jar>().all(block)
}

fun Project.compileKotlin(block: KotlinCompile.() -> Unit) {
    tasks.withType(block)
}