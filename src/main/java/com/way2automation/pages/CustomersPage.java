package com.way2automation.pages;

import com.way2automation.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import static com.way2automation.browserfactory.ManageBrowser.driver;

public class CustomersPage extends Utility {
    public CustomersPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "userSelect")
    WebElement nameDropdown;

    public void searchAndSelectNameFormDropdown(String text) {
        Reporter.log("Selected " + text + " from " + nameDropdown.toString());
        selectByVisibleTextFromDropDown(nameDropdown, text);
    }

}
