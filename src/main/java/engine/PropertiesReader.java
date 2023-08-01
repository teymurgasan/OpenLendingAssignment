package engine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public enum PropertiesReader {

    CONFIGURATIONS("src/main/resources/configuration.properties"),
    URL("src/main/resources/url.properties");

    private final Logger LOG = LoggerFactory.getLogger(PropertiesReader.class);
    private Properties properties;

    PropertiesReader(String path) {
        try {
            FileInputStream input = new FileInputStream(path);
            properties = new Properties();
            properties.load(input);
            input.close();

            LOG.info("Properties file on path '{}' was loaded", path);

            input.close();
        } catch (FileNotFoundException e) {
            LOG.warn("There is no property file on path '{}'", path);
        } catch (IOException e) {
            LOG.warn("Could not load properties on path '{}'", path);
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
