package com.gittigidiyor.test.automation.controller;

import com.gittigidiyor.test.automation.constants.ApplicationConstants;
import com.gittigidiyor.test.automation.util.ElementUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickLoginButton()  {
        navigate(ApplicationConstants.LOGIN_PAGE_URL);
        log.info("Login page opened.");
    }

    public void search (String params) {
        navigate(ApplicationConstants.BASE_URL);

        WebElement element = find(ElementUtils.SEARCH_BAR);
        element.sendKeys(params);

        click(ElementUtils.SEARCH_BUTTON);
        log.info("Successfully search by params");
    }

}