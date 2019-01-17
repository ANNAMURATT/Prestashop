package com.prestashop.tests.smoke_tests;

import com.prestashop.utilities.ConfigurationReader;
import com.prestashop.utilities.Driver;
import com.prestashop.utilities.Testbase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ProductInformation  extends Testbase {

    @Test
    public void productTest(){

        WebElement product = driver.findElement(By.linkText("Faded Short Sleeve T-shirts"));

        String productName = driver.findElement(By.linkText("Faded Short Sleeve T-shirts")).getText();
        String productPrice = driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[2]/div[1]/span")).getText();

        product.click();

        String productName2 = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div/div[3]/h1")).getText();

        String productPrice2 = driver.findElement(By.xpath("//*[@id=\"our_price_display\"]")).getText();

        Assert.assertEquals(productName,productName2);

        Assert.assertEquals(productPrice,productPrice2);

    }

    @Test
    public void productDetailsTest(){
        WebElement product = driver.findElement(By.linkText("Faded Short Sleeve T-shirts"));
        product.click();

        String quantity = driver.findElement(By.id("quantity_wanted")).getText();
        System.out.println("quantity:"+quantity);
        String size = driver.findElement(By.id("group_1")).getText();

        WebElement selectSize = driver.findElement(By.id("group_1"));
        Select list = new Select(selectSize);

        List<WebElement> getSizes =list.getOptions();

        StringBuilder sb = new StringBuilder();
        for (WebElement w: getSizes)
            sb.append(w.getText());

           Assert.assertEquals(quantity,"1");
        Assert.assertEquals(list.getFirstSelectedOption().getText(),"S");

        Assert.assertEquals(sb.toString(),"SML");

    }

    @Test
    public void addToCart(){
        WebElement product = driver.findElement(By.linkText("Faded Short Sleeve T-shirts"));
        product.click();
        WebElement chart = driver.findElement(By.id("add_to_cart"));
        chart.click();

        System.out.println(driver.findElement(By.id("layer_cart_product_quantity")).getText());
    }


}
