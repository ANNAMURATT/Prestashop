package com.prestashop.tests.functional_tests;

import com.prestashop.pages.HomePage2;
import com.prestashop.pages.Homepage;
import com.prestashop.utilities.ConfigurationReader;
import com.prestashop.utilities.Testbase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTests extends Testbase {


    @Test
    public void test1(){
        Assert.assertEquals(driver.getTitle(),"Web Orders Login");
        HomePage2 homepage = new HomePage2();
        homepage.userName.sendKeys(ConfigurationReader.getProperty("username"));
        homepage.password.sendKeys(ConfigurationReader.getProperty("password"));
        homepage.login.click();

        Assert.assertTrue(driver.getTitle().equals("Web Orders"));

        String currentUrl = "http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/";
        Assert.assertEquals(driver.getCurrentUrl(),currentUrl);

    }


}
