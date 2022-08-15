package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLoader {

    private final Properties properties;

    public PropertiesLoader(String fileName) {
        try{
            FileInputStream fileInputStream = new FileInputStream(new File((System.getProperty("user.dir")+"/src/test/resources"+fileName)));
            properties = new Properties();
            properties.load(fileInputStream);
        }catch (IOException e){
            throw new RuntimeException();
        }
    }
    public String getValue(String key){
        return properties.getProperty(key);
    }

}
