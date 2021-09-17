package com.gittigidiyor.test.automation;

import com.gittigidiyor.test.automation.constants.ApplicationConstants;
import com.gittigidiyor.test.automation.controller.HomePage;
import com.gittigidiyor.test.automation.util.EnvironmentManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BaseTest {

    HomePage homePage;
    WebDriver driver = EnvironmentManager.openChromeDriver();

    @Test
    @Order(1)
    public void setUp() {
        driver.manage().window().maximize();
        homePage =  new HomePage(driver);
        driver.get(ApplicationConstants.BASE_URL);

        Assertions.assertEquals(driver.getTitle(), ApplicationConstants.BASE_TITLE , "Home page is not correct");
        homePage.clickLoginButton();
    }

    @AfterAll
    public void tearDown() {
        driver.quit();
    }

}

