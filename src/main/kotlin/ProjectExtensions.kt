import org.gradle.api.Project
import com.android.build.gradle.TestedExtension as AndroidBlock
import org.gradle.api.artifacts.dsl.DependencyHandler as DependenciesBlock
import org.gradle.kotlin.dsl.PluginDependenciesSpecScope as PluginsBlock


fun Project.findProp(s: String) = project.findProperty(s) as String