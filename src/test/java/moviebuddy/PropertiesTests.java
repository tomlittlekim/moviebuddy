package moviebuddy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class PropertiesTests {

    @Test
    void Load_PropertiesFile() throws IOException {
        Properties properties = new Properties();
        properties.load(Files.newInputStream(Paths.get("./src/test/resources/config.properties")));

        Assertions.assertEquals(1, properties.size());
    Assertions.assertEquals("arawn", properties.get("name"));
    }

}
