package com.way2automation.pages;

import com.way2automation.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import static com.way2automation.browserfactory.ManageBrowser.driver;

public class HomePage extends Utility {
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[contains(text(),'Bank Manager Login')]")
    WebElement bankManagerLoginTab;
    @FindBy(xpath = "//button[@ng-click='customer()']")
    WebElement customerLoginTab;

    public void clickOnBankManagerLoginTab() {
        Reporter.log("Clicked on bank manager login tab " + bankManagerLoginTab.toString());
        clickOnElement(bankManagerLoginTab);

    }

    public void clickOnCustomerLoginTab() {
    }
}