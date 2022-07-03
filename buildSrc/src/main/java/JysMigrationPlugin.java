import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class JysMigrationPlugin implements Plugin<Project> {

    @Override
    public void apply(Project project) {
        project.getExtensions().create("tables", TableExtension.class);

        project.getTasks().register("Migration", MigrationTask.class, action -> {
            action.setProperty("tableName", ((TableExtension)project.getExtensions().getByName("tables")).getTableName());
            action.doFirst(sub -> System.out.println("Start Migration"));
            action.doLast(sub -> System.out.println("Success Migration"));
        });

        project.getTasks().register("Clear", ClearTask.class, action -> {
            action.setProperty("tableName", ((TableExtension)project.getExtensions().getByName("tables")).getTableName());
            action.doFirst(sub -> System.out.println("Start Clear"));
            action.doLast(sub -> System.out.println("Success Clear"));
        });
    }
}
