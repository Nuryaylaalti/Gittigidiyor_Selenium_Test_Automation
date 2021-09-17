package com.gittigidiyor.test.automation.controller;

import com.gittigidiyor.test.automation.model.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    WebDriver driver ;
    Log log;

    public BasePage(WebDriver driver){
        this.driver = driver ;
        log = new Log();
    }

    public WebElement find(By locator){
        return driver.findElement(locator);
    }

    public void click(By locator){
        find(locator).click();
    }

    public void sendKeys(By locator, String params){
        WebElement element = find(locator);
        element.click();
        element.sendKeys(params);
    }

   public void navigate(String url){
       driver.navigate().to(url);
   }

}
