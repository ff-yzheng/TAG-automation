package global;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtil {

    private static Properties properties = loadPropertiesFile(Constants.CONFIG_DIR, Constants.CONFIG_FILE_NAME);

    public static Properties loadPropertiesFile(String directory, String filename) {
        File configFile = new File(directory, filename);
        return getProps(configFile);
    }

    public void setProperty(String key, String value) {
        properties.setProperty(key, value);
    }

    private static Properties getProps(final File file) {
        Properties properties = null;
        try {
            properties = new Properties();
            properties.load(new FileInputStream(file));
        } catch (IOException ioException) {
            System.err.println(ioException);
        }
        return properties;
    }
}
