package com.way2automation.pages;

import com.way2automation.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import static com.way2automation.browserfactory.ManageBrowser.driver;

public class BankManagerLoginPage extends Utility {

    public BankManagerLoginPage() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[@ng-click='addCust()']")
    WebElement addCustomerTab;
    @FindBy(xpath = "//button[@ng-click='openAccount()']")
    WebElement openAccountTab;
    @FindBy(xpath = "//button[@ng-click='showCust()']")
    WebElement customersTab;

    public void clickOnAddCustomerTab() {
        Reporter.log("Clicked on add customer tab " + addCustomerTab.toString());
        clickOnElement(addCustomerTab);
    }

    public void clickOnOpenAccountTab() {
        Reporter.log("Clicked on open account tab " + openAccountTab.toString());
        clickOnElement(openAccountTab);
    }

    public void clickOnCustomersTab() {
        Reporter.log("Clicked on customers tab " + customersTab.toString());
        clickOnElement(customersTab);
    }

    public String getPopupMsg() {
        return getTextFromAlert();
    }

    public void clickOKOnPopup() {
        Reporter.log("Accepted popup");
        acceptAlert();
    }
}
