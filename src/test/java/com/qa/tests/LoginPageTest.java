package com.qa.tests;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;


    public LoginPageTest()
    {
        super();
    }

    @BeforeMethod
    public void setup() throws InterruptedException {
        initialization();
        loginPage = new LoginPage();
        loginPage.removePrivacyError();
    }

    @Test(priority=1)
    public void loginPageTitleTest() throws InterruptedException {
        String title = loginPage.validateLoginPageTitle();
        Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
    }

    @Test(priority=2)
    public void crmLogoImageTest(){
        boolean flag = loginPage.validateCRMImage();
        Assert.assertTrue(flag);
    }

    @Test(priority=3)
    public void loginTest(){
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }


    @AfterMethod
    public void teardown()
    {
        driver.quit();
    }

}
