import org.gradle.api.tasks.TaskAction;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class MigrationTask extends JysMigrationTask {

    public MigrationTask() throws Exception {
        super();
    }

    @TaskAction
    void migration() throws SQLException {
        String sql = String.format("create table %s(id bigint primary key auto_increment)", this.getTableName().get());
        try(PreparedStatement preparedStatement = this.connection.prepareStatement(sql)) {
            preparedStatement.execute();
            System.out.println("Migration Execute");
        } catch(Exception e) {
            System.out.println("Migration Error");
        } finally {
            this.connection.close();
        }
    }
}
