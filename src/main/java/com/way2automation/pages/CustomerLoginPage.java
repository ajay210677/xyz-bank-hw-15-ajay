package com.way2automation.pages;

import com.way2automation.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CustomerLoginPage extends Utility {

    public CustomerLoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[contains(text(),'Login')]")
    WebElement loginButton;
    @FindBy(xpath = "//button[contains(text(),'Logout')]")
    WebElement logoutText;
    @FindBy(xpath = "//button[contains(text(),'Logout')]")
    WebElement logoutButton;
    @FindBy(xpath = "//label[contains(text(),'Your Name :')]")
    WebElement yourNameTextAfterLogout;

    public void clickOnLoginButton() {
        Reporter.log("Clicked on login button " + loginButton.toString());
        clickOnElement(loginButton);
    }

    public String getNameTextAfterLogout() {
        return getTextFromElement(yourNameTextAfterLogout);
    }
}