package com.prestashop.pages;

import com.prestashop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
    public Homepage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

        @FindBy(id = "header")
        public WebElement header;

        @FindBy(linkText = "Sign in")
        public WebElement signIn;

        @FindBy(id = "email")
        public WebElement email;

        @FindBy(id = "passwd")
        public WebElement password;

        @FindBy(id="SubmitLogin")
        public WebElement loginButton;

        @FindBy(linkText = "MY PERSONAL INFORMATION")
        public WebElement myInfo;

        @FindBy(linkText = "MY ADDRESSES")
        public WebElement myAddress;

        @FindBy(xpath = "//span[.='Save']")
        public WebElement saveInfo;

        @FindBy(linkText = "Back to your account")
        public WebElement backToAccount;
}
