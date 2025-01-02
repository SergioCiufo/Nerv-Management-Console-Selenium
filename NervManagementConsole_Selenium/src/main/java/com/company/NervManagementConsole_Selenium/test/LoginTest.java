package com.company.NervManagementConsole_Selenium.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    public void testLogin(String driverChoice) {

    	//String driverChoice = "firefox";
        setUp(driverChoice);

        // Vai alla pagina di login
        driver.get("http://localhost:8080/NervManagementConsoleREST/jsp/private/Login.jsp");

        // Esegui il login
        //prende di riferimento il by name della jsp
        WebElement usernameField = driver.findElement(By.name("loginUsername"));
        WebElement passwordField = driver.findElement(By.name("loginPassword"));
        
        /////////////////////////////////////////////////////////////////////////////////////////////////
        // Carica i dati dal file application.properties (passaggio inutile, solo a termini di esempio //
        Properties properties = new Properties();
        try {
            FileInputStream fis = new FileInputStream("src/resources/application.properties");
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String username=properties.getProperty("login.username");
        usernameField.sendKeys(username);
        String password = properties.getProperty("login.password");
        passwordField.sendKeys(password);
        /////////////////////////////////////////////////////////////////////////////////////////////////
        
        //Sennò si poteva fare benissimo così senza fare application.properties etc etc
        //usernameField.sendKeys("admin");
        //passwordField.sendKeys("admin");
        
        //prende di riferimento il by id della submit della jsp
        driver.findElement(By.id("loginSubmit")).click();

        // Verifica se il login è riuscito
        String expectedUrl = "http://localhost:8080/NervManagementConsoleREST/jsp/private/Home.jsp";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.equals(expectedUrl)) {
            System.out.println("Successful login on " + driverChoice);
        } else {
            System.out.println("Failed Login on "+ driverChoice);
        }

        // Chiudi il browser
        tearDown();
    }
}