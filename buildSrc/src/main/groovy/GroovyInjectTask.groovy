import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

import javax.inject.Inject

abstract class GroovyInjectTask extends DefaultTask {

    private final String message;

    @Inject
    GroovyInjectTask(String message) {
        this.message = message;
    }

    @TaskAction
    void print() {
        println this.message
    }
}
