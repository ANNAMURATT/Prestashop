package com.prestashop.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public abstract class Testbase {
    protected WebDriver driver=Driver.getDriver();
    protected WebElement username;
    protected WebElement password;
    protected WebElement login;
    protected Actions actions;

    @BeforeMethod
    public void setUp(){
        actions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.getProperty("url"));
    }

//    @AfterMethod
//    public void closeUp(){
//        driver.quit();
//    }

}
