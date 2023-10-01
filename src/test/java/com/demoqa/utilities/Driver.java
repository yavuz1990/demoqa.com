package com.demoqa.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Driver {

    /*
    Creating a private constructor, so we are closing
    access to the object of this class from outside the class
     */
    private Driver() {
    }

    /*
    We make WebDriver private, because we want to close access from outside the class.
    We make it static because we will use it in a static method.
     */
    //private static WebDriver driver; // value is null by default

    private static WebDriver driver;

    /*
    Create a re-usable utility method which will return same driver instance when we call it
     */
    public static WebDriver getDriver() {

        if (driver == null) {

            /*
            We read our browserType from configuration.properties.
            This way, we can control which browser is opened from outside our code, from configuration.properties.
             */
            String browserType = ConfigurationReader.getProperty("browser");


            /*
                Depending on the browserType that will be return from configuration.properties file
                switch statement will determine the case, and open the matching browser
            */
            switch (browserType) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    driver=new FirefoxDriver();
                    break;
                case "edge":
                    driver=new EdgeDriver();
                    break;
                case "headless-chrome":
                    ChromeOptions chromeOptions=new ChromeOptions();
                    chromeOptions.setHeadless(true);
                    driver=new ChromeDriver(chromeOptions);
                    break;
                default:
                    driver=new ChromeDriver();


            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        }

        return driver;
    }
    /*
    This method will make sure our driver value is always null after using quit() method
     */
    public static void closeDriver() {
        if (driver != null) {
            driver.quit(); // this line will terminate the existing session. value will not even be null
            driver = null;
        }
    }
}

