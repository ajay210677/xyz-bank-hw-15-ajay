package com.way2automation.pages;

import com.way2automation.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import static com.way2automation.browserfactory.ManageBrowser.driver;

public class AddCustomerPage extends Utility {
    public AddCustomerPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstNameField;
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastNameField;
    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement postcodeField;
    @FindBy(xpath = "//button[@class='btn btn-default']")
    WebElement addCustomerButton;

    public void enterFirstName(String text) {
        Reporter.log("Entered first name " + text + " in first name field " + firstNameField.toString());
        sendTextToElement(firstNameField, text);
    }

    public void enterLastName(String text) {
        Reporter.log("Entered last name " + text + " in last name field " + lastNameField.toString());
        sendTextToElement(lastNameField, text);
    }

    public void enterPostcode(String text) {
        Reporter.log("Entered Postcode " + text + " in postcode field " + postcodeField.toString());
        sendTextToElement(postcodeField, text);
    }

    public void clickOnAddCustomerButton() {
        Reporter.log("Clicked on add customer button " + addCustomerButton.toString());
        clickOnElement(addCustomerButton);
    }
}
