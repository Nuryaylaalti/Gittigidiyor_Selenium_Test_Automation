package com.gittigidiyor.test.automation;

import com.gittigidiyor.test.automation.constants.ApplicationConstants;
import com.gittigidiyor.test.automation.controller.CartPage;
import com.gittigidiyor.test.automation.controller.LoginPage;
import com.gittigidiyor.test.automation.controller.ProductPage;
import com.gittigidiyor.test.automation.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class ApplicationTest extends BaseTest {

    @Test
    @Order(2)
    public void onClickLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        User user = new User(ApplicationConstants.EMAIL, ApplicationConstants.PASSWORD);
        loginPage.fillUserName(user.getEmail());

        Assertions.assertEquals(user.getEmail(), loginPage.getUserName(), "Username is not correct");
        Thread.sleep(100);

        loginPage.fillPassword(user.getPassword());
        Assertions.assertEquals(user.getPassword(), loginPage.getPassword(), "Password is not correct");
        Thread.sleep(100);

        loginPage.onClickLogin();
    }


    @Test
    @Order(3)
    public void goToSecondPageStep() throws InterruptedException {
        homePage.search(ApplicationConstants.SEARCH_PARAM);
        Thread.sleep(1000);

        ProductPage productPage = new ProductPage(driver);
        productPage.goToSecondPage();
        Assertions.assertEquals(driver.getCurrentUrl(), ApplicationConstants.SECOND_PAGE_URL, "Current page is not found.");
        Thread.sleep(1000);
    }

    @Test
    @Order(4)
    public void addProductToCartAndComparePrice() throws InterruptedException {
        ProductPage productPage = new ProductPage(driver);
        WebElement selectedProduct = productPage.getSelectedRandomProduct();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selectedProduct);
        String firstPrice = productPage.getSelectedProductPrice(selectedProduct);

        selectedProduct.click();
        Thread.sleep(1000);
        productPage.addProductToCart();
        Thread.sleep(1000);
        productPage.goToMyCart();

        CartPage cartPage = new CartPage(driver);
        WebElement firstProduct = cartPage.getFirstProduct();
        String priceInCart = cartPage.getProductsPrice(firstProduct);
        Assertions.assertEquals(firstPrice, priceInCart, "Product price test failed.");
        Thread.sleep(1000);

        cartPage.changeProductCount(firstProduct);
        Thread.sleep(1000);
        String productCount = cartPage.getProductCount(firstProduct);
        Thread.sleep(1000);
        Assertions.assertEquals(productCount, "2", "Product count test failed.");
    }

    @Test
    @Order(5)
    public void removeFromCart() throws InterruptedException {
        CartPage cartPage = new CartPage(driver);
        WebElement firstProduct = cartPage.getFirstProduct();
        cartPage.removeFirstItemFromBasket(firstProduct);
        Thread.sleep(10000);

        int numberOfProducts = cartPage.getNumberOfProducts();
        Assertions.assertEquals(numberOfProducts, 0, "Product not remove from cart.");
    }



}

