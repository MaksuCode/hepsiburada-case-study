package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Manages driver instance
 */
public class DriverManager {

    public static WebDriver driver;

    /**
     * Initalize driver
     * @param browser is passed by -Dbrowser on commandline
     */
    public static void initialize(String browser){
        switch (browser){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
        }
        driver.manage().window().maximize();
    }

    /**
     * Quits the driver.
     */
    public static void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

}
