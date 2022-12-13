package com.way2automation.testbase;

import com.way2automation.propertyreader.PropertyReader;
import com.way2automation.utility.Utility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest extends Utility {

    String browser = PropertyReader.getInstance().getProperty("browser");

    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        selectBrowser(browser);
    }

    public void selectBrowser(String browser) {

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        closeBrowser();
    }
}
