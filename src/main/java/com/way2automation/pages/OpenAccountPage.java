package com.way2automation.pages;


import com.way2automation.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import static com.way2automation.browserfactory.ManageBrowser.driver;

public class OpenAccountPage extends Utility {
    public OpenAccountPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "userSelect")
    WebElement customerDropdown;
    @FindBy(id = "currency")
    WebElement currencyDropdown;
    @FindBy(xpath = "//button[contains(text(),'Process')]")
    WebElement processButton;

    public void searchAndSelectCreatedCustomer(String text) {
        Reporter.log("Selected " + text + " from " + customerDropdown.toString());
        selectByVisibleTextFromDropDown(customerDropdown, text);
    }

    public void selectPoundInCurrency(String text) {
        Reporter.log("Selected " + text + " from " + currencyDropdown.toString());
        selectByVisibleTextFromDropDown(currencyDropdown, text);
    }

    public void clickOnProcessButton() {
        Reporter.log("Clicked on process button " + processButton.toString());
        clickOnElement(processButton);
    }

}
