import org.gradle.api.provider.Property;

public interface TableExtension {
    Property<String> getTableName();
}
