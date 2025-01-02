package com.company.NervManagementConsole_Selenium.test;

import org.openqa.selenium.WebDriver;

import com.company.NervManagementConsole_Selenium.utils.WebDriverFactory;

public class BaseTest {
    protected WebDriver driver;

    public void setUp(String browser) {
        // Crea il WebDriver in base al browser scelto
        driver = WebDriverFactory.getDriver(browser);
        driver.manage().window().maximize();
    }
    
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Chiude il browser e termina il WebDriver
        }
    }
}