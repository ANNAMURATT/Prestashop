package com.prestashop.tests.smoke_tests;

import com.prestashop.pages.Homepage;
import com.prestashop.utilities.ConfigurationReader;
import com.prestashop.utilities.Testbase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Accountinformation extends Testbase {

    @Test
    public void myAccount(){
        Homepage homepage = new Homepage();
        homepage.signIn.click();
        homepage.email.sendKeys(ConfigurationReader.getProperty("username"));
        homepage.password.sendKeys(ConfigurationReader.getProperty("password"));
        homepage.loginButton.click();
//        System.out.println(driver.getTitle());
//
//        Assert.assertTrue(driver.getTitle().contains("My account"));

//Verify	that	account	holder	full	name	is	displayed	next	to	the	Sign	out	link

    }

    @Test
    public void myPersonalInfo(){

        myAccount();
        Homepage homepage = new Homepage();

        homepage.myInfo.click();
        Assert.assertTrue(driver.getTitle().contains("Identity"));
        //        Verify	that first	name	and	last	name	matches	the	full	name	on	top

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        homepage.saveInfo.click();
        String error = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div/ol/li")).getText();
        Assert.assertEquals(error,"The password you entered is incorrect.");

        homepage.backToAccount.click();
        Assert.assertTrue(driver.getTitle().contains("My account"));
    }

    @Test
    public void login() {
        myAccount();
        Homepage homepage = new Homepage();
        homepage.myAddress.click();

        WebElement newAddress = driver.findElement(By.linkText("Add a new address"));
        newAddress.click();
//        Verify	that first	name	and	last	name	matches	the	full	name	on	top
        WebElement firstname = driver.findElement(By.id("firstname"));
        firstname.clear();
        driver.findElement(By.id("submitAddress"));
//        Verify	error	message	“firstname	is	required.”

    }


}
