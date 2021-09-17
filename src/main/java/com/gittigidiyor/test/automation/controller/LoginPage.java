package com.gittigidiyor.test.automation.controller;

import com.gittigidiyor.test.automation.constants.ApplicationConstants;
import com.gittigidiyor.test.automation.util.ElementUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {


    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public void fillUserName(String userName) {
        sendKeys(ElementUtils.LOGIN_PAGE_USERNAME, userName);
        log.info("UserName filled.");
    }

    public void fillPassword(String password) {
        sendKeys(ElementUtils.LOGIN_PAGE_PASSWORD, password);
        log.info("Password filled.");
    }

    public void onClickLogin() {
        click(ElementUtils.LOGIN_BUTTON);
        log.info("Enter the application.");
    }

    public String getUserName(){
        WebElement element = find(ElementUtils.LOGIN_PAGE_USERNAME);
        return element.getAttribute(ApplicationConstants.VALUE);
    }

    public String getPassword(){
        WebElement element = find(ElementUtils.LOGIN_PAGE_PASSWORD);
        return element.getAttribute(ApplicationConstants.VALUE);
    }

}
