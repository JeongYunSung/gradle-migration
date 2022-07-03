import org.gradle.api.DefaultTask
import org.gradle.api.provider.Property
import org.gradle.api.provider.Provider
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.Internal
import org.gradle.api.tasks.TaskAction

abstract class GroovyExtensionTask extends DefaultTask {

    @Input
    abstract Property<Integer> getCode()

    @Internal
    final Provider<String> message = code.map { "CODE - " + it }

    @TaskAction
    void print() {
        println message.get()
    }
}
