package com.way2automation.testsuite;

import com.way2automation.pages.*;
import com.way2automation.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BankTest  extends BaseTest {
    HomePage homePage;
    BankManagerLoginPage bankManagerLoginPage;
    AddCustomerPage addCustomerPage;
    CustomersPage customersPage;
    OpenAccountPage openAccountPage;
    CustomerLoginPage customerLoginPage;
    AccountPage accountPage;

    public BankTest() {
    }

    @BeforeMethod(
            alwaysRun = true
    )
    public void inIt() {
        this.homePage = new HomePage();
        this.bankManagerLoginPage = new BankManagerLoginPage();
        this.addCustomerPage = new AddCustomerPage();
        this.customersPage = new CustomersPage();
        this.openAccountPage = new OpenAccountPage();
        this.customerLoginPage = new CustomerLoginPage();
        this.accountPage = new AccountPage();
    }

    @Test(
            groups = {"sanity", "regression"}
    )
    public void bankManagerShouldAddCustomerSuccessfully() {
        this.homePage.clickOnBankManagerLoginTab();
        this.bankManagerLoginPage.clickOnAddCustomerTab();
        this.addCustomerPage.enterFirstName("Abc");
        this.addCustomerPage.enterLastName("Xyz");
        this.addCustomerPage.enterPostcode("EC1B 2JL");
        this.addCustomerPage.clickOnAddCustomerButton();
        Assert.assertTrue(this.bankManagerLoginPage.getPopupMsg().contains("Customer added successfully"), "Message not found");
        this.bankManagerLoginPage.clickOKOnPopup();
    }

    @Test(
            groups = {"sanity", "regression"}
    )
    public void bankManagerShouldOpenAccountSuccessfully() {
        this.homePage.clickOnBankManagerLoginTab();
        this.bankManagerLoginPage.clickOnOpenAccountTab();
        this.openAccountPage.searchAndSelectCreatedCustomer("Harry Potter");
        this.openAccountPage.selectPoundInCurrency("Pound");
        this.openAccountPage.clickOnProcessButton();
        Assert.assertTrue(this.bankManagerLoginPage.getPopupMsg().contains("Account created successfully"), "Message not found");
        this.bankManagerLoginPage.clickOKOnPopup();
    }

    @Test(
            groups = {"smoke", "regression"}
    )
    public void customerShouldLoginAndLogoutSuccessfully() {
        this.homePage.clickOnCustomerLoginTab();
        this.customersPage.searchAndSelectNameFormDropdown("Harry Potter");
        this.customerLoginPage.clickOnLoginButton();
        this.customerLoginPage.clickOnLogoutButton();
        Assert.assertTrue(this.customerLoginPage.getNameTextAfterLogout().contains("Your Name"), "Text not found");
    }

    @Test(
            groups = {"smoke", "regression"}
    )
    public void customerShouldDepositMoneySuccessfully() {
        this.homePage.clickOnCustomerLoginTab();
        this.customersPage.searchAndSelectNameFormDropdown("Harry Potter");
        this.customerLoginPage.clickOnLoginButton();
        this.accountPage.clickOnDepositTab();
        this.accountPage.enterAmountToDeposit("100");
        this.accountPage.clickOnDepositButton();
        Assert.assertEquals(this.accountPage.getDepositMsg(), "Deposit Successful", "Message not found");
    }

    @Test(
            groups = {"smoke", "regression"}
    )
    public void customerShouldWithdrawMoneySuccessfully() throws InterruptedException {
        this.homePage.clickOnCustomerLoginTab();
        this.customersPage.searchAndSelectNameFormDropdown("Harry Potter");
        this.customerLoginPage.clickOnLoginButton();
        this.accountPage.clickOnDepositTab();
        this.accountPage.enterAmountToDeposit("100");
        this.accountPage.clickOnDepositButton();
        this.accountPage.clickOnWithdrawTab();
        Thread.sleep(1000L);
        this.accountPage.enterAmountToWithdraw("50");
        this.accountPage.clickOnWithdrawButton();
        Thread.sleep(1000L);
        Assert.assertTrue(this.accountPage.getWithdrawMsg().contains("Transaction successful"), "Message not found");
    }
}
