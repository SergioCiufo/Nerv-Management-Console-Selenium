package com.company.NervManagementConsole_Selenium.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.opera.OperaDriver;

public class WebDriverFactory {
	//seleziona il driver in base alla scelta
    public static WebDriver getDriver(String browserChoice) {
        WebDriver driver = null;

        switch (browserChoice.toLowerCase()) {
            case "chrome":
            case "1":
                System.setProperty("webdriver.chrome.driver", "src/resources/driver/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "firefox":
            case "2":
                System.setProperty("webdriver.gecko.driver", "src/resources/driver/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case "edge":
            case "3":
                System.setProperty("webdriver.edge.driver", "src/resources/driver/msedgedriver.exe");
                driver = new EdgeDriver();
                break;
            case "opera":
            case "4":
                System.setProperty("webdriver.opera.driver", "src/resources/driver/operadriver.exe");
                driver = new OperaDriver();
                break;
            default:
                throw new IllegalArgumentException("Browser not supported or wrong type: " + browserChoice);
        }

        return driver;
    }
}