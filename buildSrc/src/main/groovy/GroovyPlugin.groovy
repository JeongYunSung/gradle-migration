import org.gradle.api.Plugin
import org.gradle.api.Project

class GroovyPlugin implements Plugin<Project> {

    private final myCode = 20220702

    @Override
    void apply(Project project) {
        project.tasks.register("GroovyInjectTask", GroovyInjectTask, "Hello Inject Task")

        project.tasks.register("GroovyInputTask", GroovyInputTask) {
            code = this.myCode
        }

        project.extensions.create('codeExt', GroovyMessageExtension)

        project.tasks.register("GroovyExtensionTask", GroovyExtensionTask) {
            code = project.codeExt.code
        }

        project.codeExt {
            code = this.myCode
        }
    }
}
