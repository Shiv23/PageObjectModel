package com.qa.pages;

import com.qa.base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    @FindBy(name="username")
    WebElement username;

    @FindBy(name="password")
    WebElement password;

    @FindBy(xpath="//input[@type='submit']")
    WebElement loginBtn;

    @FindBy(xpath="//button[contains(text(),'Sign Up')]")
    WebElement signUpBtn;

    @FindBy(xpath="//img[contains(@class,'img-responsive')]")
    WebElement crmLogo;

    @FindBy(xpath = "//button[@id='details-button']")
    WebElement advancedBtn;

    @FindBy(xpath = "//a[@id= 'proceed-link']")
    WebElement proceedLink;

    public LoginPage()
    {
        PageFactory.initElements(driver, this);
    }

    public void removePrivacyError() throws InterruptedException {
        Thread.sleep((2000));
        advancedBtn.click();
        Thread.sleep((1000));
        proceedLink.click();
    }

    public String validateLoginPageTitle() throws InterruptedException {
        return driver.getTitle();
    }

    public boolean validateCRMImage(){
        return crmLogo.isDisplayed();
    }

    public HomePage login(String un, String pwd){
        username.sendKeys(un);
        password.sendKeys(pwd);
        //loginBtn.click();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", loginBtn);

        return new HomePage();
    }

}
