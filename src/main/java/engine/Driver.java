package engine;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class Driver {

    private static final Logger LOG = LoggerFactory.getLogger(Driver.class);
    private static WebDriver driver;

    private Driver() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            switch (PropertiesReader.CONFIGURATIONS.getProperty("browser")) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();

                    if (PropertiesReader.CONFIGURATIONS.getProperty("headless").equals("true")) {
                        options.addArguments("--headless");
                        LOG.info("Driver is in headless mode");
                    }

                    driver = new ChromeDriver(options);
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

                    LOG.info("Chrome Driver was initialized");
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

                    LOG.info("FireFox Driver was initialized");
                    break;
            }
        }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        LOG.info("Browser was closed\n");
        driver = null;
    }
}
