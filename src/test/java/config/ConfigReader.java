package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static String BROWSER = getValuePropertyFromConfig("Browser");
    public static String HEADLESS = getValuePropertyFromConfig("Browser_headless");
    public static Integer WAIT_TIMEOUT = Integer.valueOf(getValuePropertyFromConfig("Wait_timeout"));
    public static String PROFILE = getValuePropertyFromConfig("User_browser_profile");


    public static String getValuePropertyFromConfig(String key) {
        Properties prop = new Properties();
        try {
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src/test/resources/config.properties");
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(key);
    }



}
