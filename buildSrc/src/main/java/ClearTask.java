import org.gradle.api.tasks.TaskAction;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class ClearTask extends JysMigrationTask {

    public ClearTask() throws Exception {
        super();
    }

    @TaskAction
    void clear() throws SQLException {
        String sql = String.format("drop table %s", this.getTableName().get());
        try(PreparedStatement statement = this.connection.prepareStatement(sql)) {
            statement.execute();
            System.out.println("Clear Execute");
        } catch(Exception e) {
            System.out.println("Clear Error");
        } finally {
            this.connection.close();
        }
    }
}
