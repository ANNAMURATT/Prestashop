package com.prestashop.tests.functional_tests;

import com.prestashop.pages.HomePage2;
import com.prestashop.utilities.ConfigurationReader;
import com.prestashop.utilities.Testbase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WONegativeLoginTests extends Testbase {

    @Test
    public void test2(){
        Assert.assertEquals(driver.getTitle(),"Web Orders Login");
        String currentUrl = driver.getCurrentUrl();
        HomePage2 homepage = new HomePage2();
        homepage.userName.sendKeys(ConfigurationReader.getProperty("username"));
        homepage.password.sendKeys(ConfigurationReader.getProperty("password"));
        homepage.login.click();

        Assert.assertTrue(driver.getTitle().equals("Web Orders Login"));
        Assert.assertTrue(driver.getCurrentUrl().equals(currentUrl));
    }
}
