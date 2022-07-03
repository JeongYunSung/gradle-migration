import org.gradle.api.DefaultTask;
import org.gradle.api.provider.Property;
import org.gradle.api.tasks.Input;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class JysMigrationTask extends DefaultTask {

    final Connection connection;

    @Input
    abstract Property<String> getTableName();

    public JysMigrationTask() throws Exception {
        Class.forName("org.mariadb.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/gradle", "root", "sjop6390");
    }
}
