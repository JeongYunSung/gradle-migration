import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction

abstract class GroovyInputTask extends DefaultTask {

    @Input
    int code;

    @TaskAction
    void print() {
        println this.code
    }
}
