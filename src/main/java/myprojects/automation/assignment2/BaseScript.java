package myprojects.automation.assignment2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Base script functionality, can be used for all Selenium scripts.
 */
public abstract class BaseScript {

    /**
     * @return New instance of {@link WebDriver} object.
     */
    public static WebDriver getDriver() {
        // TODO return  WebDriver instance
        String driverPath = "src\\main\\resources\\chromedriver.exe";
        if (driverPath == null)
            throw new UnsupportedOperationException("Method doesn't return WebDriver instance");

        System.setProperty("webdriver.chrome.driver", driverPath);
        return new ChromeDriver();

    }
}




